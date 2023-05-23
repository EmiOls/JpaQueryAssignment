import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import se.yrgo.domain.Student;
import se.yrgo.domain.Subject;
import se.yrgo.domain.Tutor;
/*
 * Change hibernate.hbm2ddl.auto to 'create' before running this main()
 */
public class CreateExampleData {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        var tutors = List.of(
            new Tutor("ABC234", "Hampus",1337),
            new Tutor("CDE567", "Nahid",13337));

        var students = List.of(
            new Student("Emil", "1-HOW-2017"),
            new Student("Anders", "2-BAJS-2018"),
            new Student("Bosse", "2-KISS-2018"),
            new Student("David", "2-SAN-2018"),
            new Student("Rasmus", "3-NIK-2019"));

        for (var tutor : tutors) {
            em.persist(tutor);
        }

        for (var student : students) {
            em.persist(student);
            tutors.get(1).addStudentToTeachingGroup(student);
        }

        var subjects = List.of(
            new Subject("Java", 3),
            new Subject("Serverprogramming", 6),
            new Subject("Clientprogramming", 2),
            new Subject("Development tools", 7)
        );

        for (var subject : subjects) {
            em.persist(subject);
        }

        tutors.get(0).addSubjectsToTeach(subjects.get(0));
        tutors.get(0).addSubjectsToTeach(subjects.get(2));
        tutors.get(1).addSubjectsToTeach(subjects.get(1));
        tutors.get(1).addSubjectsToTeach(subjects.get(3));

        tx.commit();
        em.close();
    }
}
