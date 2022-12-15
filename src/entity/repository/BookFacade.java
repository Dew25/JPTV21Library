/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.repository;

import entity.Author;
import entity.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Melnikov
 */
public class BookFacade extends AbstractFacade<Book>{
    private final EntityManager em;
    
    
    public BookFacade() {
        super(Book.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV21LibraryPU");
        em = emf.createEntityManager();
        
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @Override
    public void save(Book book){
        em.getTransaction().begin();
            for (int i = 0; i < book.getAuthors().size(); i++) {
                Author author = book.getAuthors().get(i);
                if(author.getId() == null){
                    em.persist(author);
                }else{
                    em.merge(author);
                }
            }
            if(book.getId() == null){
                em.persist(book);
            }else{
                em.merge(book);
            }
        em.getTransaction().commit();
    }
    

    
    
}
