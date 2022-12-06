/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers.basemanager;

import entity.Book;
import entity.History;
import entity.Reader;
import interfaces.DataPersistenceManage;
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
public class DataBaseManager implements DataPersistenceManage{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV21LibraryPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    
    @Override
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
    @Override
    public List<Book> loadBooks(){
        try {
            return em.createQuery("SELECT b FROM Book b")
                    .getResultList();
        } catch (Exception ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, "Неудалось загрузить книги", ex);
            return new ArrayList<>();
        }
    }
    @Override
    public void saveReaders(List<Reader> readers) {
        tx.begin();
            for (int i = 0; i < readers.size(); i++) {
                Reader reader = readers.get(i);
                if(reader.getId() == null){
                    em.persist(reader);
                }else{
                    em.merge(reader);
                }
            }
        tx.commit();
        
    }
    @Override
    public List<Reader> loadReaders(){
        try {
            return em.createQuery("SELECT r FROM Reader r")
                    .getResultList();
        } catch (Exception ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, "Неудалось загрузить читателей", ex);
            return new ArrayList<>();
        }
    }
    @Override
    public void saveHistories(List<History> histories) {
        tx.begin();
            for (int i = 0; i < histories.size(); i++) {
                History history = histories.get(i);
                if(history.getId() == null && history.getReturnBook() == null){
                    em.persist(history);
                }else{
                    em.merge(history);
                }
            }
        tx.commit();
    }
    @Override
    public List<History> loadHistories() {
        try {
            return em.createQuery("SELECT h FROM History h")
                    .getResultList();
        } catch (Exception ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, "Неудалось загрузить истории", ex);
            return new ArrayList<>();
        }
    }
    
    
}
