/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Candy;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author alber
 */
public class CandyFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public List<Candy> getAllCandy() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT c FROM Candy c");
        List<Candy> candy = (List<Candy>) query.getResultList();
        em.close();
        return candy;

    }

    public Candy getCandyById(int id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Candy c WHERE c.id =:id");
        query.setParameter("id", id);
        Candy c = (Candy) query.getSingleResult();
        em.close();
        return c;
    }
}
