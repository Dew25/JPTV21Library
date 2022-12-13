/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.repository;

import entity.History;
import entity.Reader;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Melnikov
 */
public class HistoryFacade {
    private final EntityManager em;
    private final EntityTransaction tx;

    public HistoryFacade() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV21LibraryPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    public void save(History history){
        tx.begin();
            em.persist(history);
        tx.commit();
    }
    public History find(Long id){
        return em.find(History.class, id);
    }
    public List<History> findAll(){
        return em.createQuery("SELECT h FROM History h")
                .getResultList();
    }
}
