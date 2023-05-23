package se.yrgo.test;
import se.yrgo.domain.Subject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TaskOne {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        var subjectDatabaseID = 9;
        var subject = em.find(Subject.class, subjectDatabaseID);

        var query = em.createQuery(
                "select t.teachingGroup from Tutor t where :subject member of t.subjectsToTeach")
                .setParameter("subject", subject);

        var students = query.getResultList();
        for (var student : students) {
            System.out.println(student);
        }
        tx.commit();
        em.close();
    }
}
