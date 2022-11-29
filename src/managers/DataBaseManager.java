/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Melnikov
 */
public class DataBaseManager {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV21LibraryPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    
    public void saveBooks(List<Book> books){
        tx.begin();
            for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if(book.getId() == null){
                em.persist(book);
            }else{
                em.merge(book);
            }
            
        }
        tx.commit();
    }
    public List<Book> loadBooks(){
        try {
            return em.createQuery("SELECT b FROM Book b")
                    .getResultList();
        } catch (Exception ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, "Неудалось загрузить книги", ex);
            return new ArrayList<>();
        }
    }
    public void saveReaders(List<Reader> readers) {
        System.out.println(new Exception());
    }
    public List<Reader> loadReaders(){
        try {
            throw new Exception();
        } catch (Exception ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    public void saveHistories(List<History> histories) {
        System.out.println(new Exception());
    }
    public List<History> loadHistories() {
        try {
            throw new Exception();
        } catch (Exception ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    
    
}
