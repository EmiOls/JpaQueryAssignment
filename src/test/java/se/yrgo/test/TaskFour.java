package se.yrgo.test;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TaskFour {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        var maxSalary = (int) em.createQuery("select max(salary) from Tutor").getSingleResult();
        System.out.println("The highest recorded salary is: " + maxSalary);

        tx.commit();
        em.close();
    }
}
