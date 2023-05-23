import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import se.yrgo.domain.Tutor;

public class TaskFive {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        var highIncomeTutors = em.createNamedQuery("searchTutorWithSalaryAbove", Tutor.class).setParameter("salary", 10000).getResultList();

        for(var tutor : highIncomeTutors) {
            System.out.println(tutor);
        }

        tx.commit();
        em.close();
    }
}
