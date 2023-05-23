package se.yrgo.test;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TaskThree {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        var avgSemesterLength = (Double) em.createQuery("select avg(numberOfSemesters) from Subject").getSingleResult();
        System.out.println("Average semester length for all subjects is: " + avgSemesterLength);

        tx.commit();
        em.close();
    }
}
