package dao;

import entities.Driver;
import entities.HistoricalJourney;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class mainDAO {

    public mainDAO() {
    }

    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conorspersistanceunit");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.close();
    }

    public void merge(Object object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        em.close();

    }

    public void remove(Object object) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
        em.close();
    }

    public List<Driver> getAllDrivers() {
        EntityManager em = emf.createEntityManager();
        List<Driver> drivers = (List<Driver>) em.createNamedQuery("Driver.findAll").getResultList();
        em.close();
        return drivers;


    }


    public List<HistoricalJourney> getAllJourneys() {
        EntityManager em = emf.createEntityManager();
        List<HistoricalJourney> journeys = (List<HistoricalJourney>) em.createNamedQuery("HistoricalJourney.findAll").getResultList();
        em.close();
        return journeys;
    }
}
