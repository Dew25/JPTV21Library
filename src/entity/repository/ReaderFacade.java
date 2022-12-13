/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.repository;

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
public class ReaderFacade {
    private final EntityManager em;
    private final EntityTransaction tx;

    public ReaderFacade() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV21LibraryPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    
    public void save(Reader reader){
        tx.begin();
            em.persist(reader);
        tx.commit();
    }
    public Reader find(Long id){
        return em.find(Reader.class, id);
    }
    public List<Reader> findAll(){
        return em.createQuery("SELECT r FROM Reader r")
                .getResultList();
    }
    
    
}
