/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.repository;

import entity.History;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Melnikov
 */
public abstract class AbstractFacade<T> {
    
    private final Class<T> entityClass;
    
    public AbstractFacade(Class<T> entityClass){
        this.entityClass = entityClass;
    }
    protected abstract EntityManager getEntityManager();
    public void save(T entity){
        getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }
    public T find(Long id){
        return getEntityManager().find(entityClass, id);
    }
    public List<T> findAll(){
        return getEntityManager().createQuery("SELECT entity FROM "+entityClass.getName()+" entity")
                .getResultList();
    }
}
