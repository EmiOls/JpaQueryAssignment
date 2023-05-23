import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

public class CreateExampleData {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Tutor t1 = new Tutor("ABC123", "Teacher 1", 290000);
        // em.persist(t1);

        // Student s1 = new Student("Student1", "1-STU-2019");
        // t1.addStudentToTeachingGroup(s1);

        // Student s2 = new Student("Student2", "2-STU-2018");
        // t1.addStudentToTeachingGroup(s2);

        // Student s3 = new Student("Student3", "3-STU-2017");
        // t1.addStudentToTeachingGroup(s3);

        // em.persist(s1);
        // em.persist(s2);
        // em.persist(s3);

        // Set<Student> allStudents = t1.getTeachingGroup();
        // System.out.println(allStudents.size());

        Tutor tutor = em.find(Tutor.class, 1);
        System.out.println(tutor);

        Set<Student> students = tutor.getTeachingGroup();
        for (Student s : students) {
            System.out.println(s);
        }

        Student student = em.find(Student.class, 2);
        System.out.println(student);

        em.remove(student);

        tx.commit();
        em.close();
    }
}
