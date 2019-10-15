package dao;

import entities.Driver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class mainDAO {

    public mainDAO() {
    }

    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conorspersistanceunit");

    public void persist(Object object)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.close();
    }

}
