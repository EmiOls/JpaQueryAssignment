import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TaskTwo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        var query = em.createQuery("select s.name, t.name from Tutor t join t.teachingGroup s");
        List<Object[]> results = query.getResultList();

        for (var result : results) {
            System.out.printf("Student: %s, Teacher: %s%n", (String) result[0], (String) result[1]);
        }
        tx.commit();
        em.close();
    }
}
