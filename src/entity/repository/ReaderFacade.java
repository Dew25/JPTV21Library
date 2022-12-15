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
public class ReaderFacade extends AbstractFacade<Reader>{
    private final EntityManager em;

    public ReaderFacade() {
        super(Reader.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV21LibraryPU");
        em = emf.createEntityManager();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}
