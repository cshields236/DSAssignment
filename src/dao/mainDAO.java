package dao;

import entities.*;

import javax.persistence.CacheRetrieveMode;
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
        List<entities.Driver> drivers = (List<entities.Driver>) em.createNamedQuery("Driver.findAll").getResultList();
        em.close();
        return drivers;


    }


    public static List<Driver> getDriverByName(String name) {
        EntityManager em = emf.createEntityManager();
        List<Driver> drivers = (List<Driver>) em.createNamedQuery("Driver.findByName").setParameter("name", name).getResultList();
        em.close();
        return drivers;

    }

    public List<Car> getAllCars() {
        EntityManager em = emf.createEntityManager();
        List<entities.Car> cars = (List<entities.Car>) em.createNamedQuery("Car.findAll").getResultList();
        em.close();
        return cars;

    }

    public static List<Car> getCarbyreg(String reg) {
        EntityManager em = emf.createEntityManager();
        List<Car> cars = (List<Car>) em.createNamedQuery("Car.findByReg").setParameter("reg", reg).getResultList();
        em.close();
        return cars;
    }


    public List<HistoricalJourney> getAllJourneys() {
        EntityManager em = emf.createEntityManager();
        List<HistoricalJourney> journeys = (List<HistoricalJourney>) em.createNamedQuery("HistoricalJourney.findAll").getResultList();
        em.close();
        return journeys;
    }

    public static List<HistoricalJourney> getJourneybyTirednessLevel(String lvl) {
        EntityManager em = emf.createEntityManager();
        List<HistoricalJourney> journeys = (List<HistoricalJourney>) em.createNamedQuery("HistoricalJourney.findByTirednessLevel").setParameter("tirednessLevel", lvl).getResultList();
        em.close();
        return journeys;

    }

    public List<Image> getAllImages() {
        EntityManager em = emf.createEntityManager();
        List<Image> images = (List<Image>) em.createNamedQuery("Image.findAll").getResultList();
        em.close();
        return images;
    }

    public static List<Image> getImageByTitle(String title) {
        EntityManager em = emf.createEntityManager();
        List<Image> images = (List<Image>) em.createNamedQuery("Image.findByTitle").setParameter("title", title).getResultList();
        em.close();
        return images;

    }

    public List<RealTimeJourney> getAllRealTimeJourney() {
        EntityManager em = emf.createEntityManager();
        List<RealTimeJourney> realTimeJourneys = (List<RealTimeJourney>) em.createNamedQuery("RealTimeJourney.findAll").getResultList();
        em.close();
        return realTimeJourneys;
    }


}

