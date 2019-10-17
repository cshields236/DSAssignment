package main;

import dao.mainDAO;
import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Test {
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conorspersistanceunit");


    public Test() {
        mainDAO mainDAO = new mainDAO();

//
//        DriverRecord rec = new DriverRecord("test");
//        mainDAO.persist(rec);
//
//         driver = new Driver("Conor","conor@conor.com", "hunter2", rec);
//
//        mainDAO.persist(driver);
//
//        Driver driver1 = new Driver("Frank","frank@conor.com", "hunter2");
//        mainDAO.persist(driver1);
//
//        List<Driver> driverList = mainDAO.getAllDrivers();
//
//
//        Car car = new Car("VW", "13-D-19008", driverList);
//        mainDAO.persist(car);


//        HistoricalJourney historicalJourney = new HistoricalJourney("23km", "high");
//        mainDAO.persist(historicalJourney);

        List<HistoricalJourney> journeys = mainDAO.getAllJourneys();
//
//        DriverRecord rec;
//        rec = new DriverRecord((ArrayList) journeys);
//        mainDAO.persist(rec);

        Image i1 = new Image("face3", "png");
        Image i2 = new Image("face4", "png");
        Image i3 = new Image("face5", "png");
        mainDAO.persist(i1);
        mainDAO.persist(i2);
        mainDAO.persist(i3);
        for (HistoricalJourney i : journeys) {
            i1.setHistoricalJourney(i);
            i2.setHistoricalJourney(i);

        }
        mainDAO.merge(i1);
        mainDAO.merge(i2);


        //REMOVE


        //MERGE
        Driver driver1 = new Driver(4, "John", "completely@email.com", "afwewef");
        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
        // use other merge thing not .merge()
//        mainDAO.remove(driver1);
//        em.close();

        Driver driver = em.find(Driver.class, 1);

        em.getTransaction().begin();
        em.remove(driver);
        em.getTransaction().commit();

    }

    public static void showTables() {
        mainDAO mainDAO = new mainDAO();
        List<HistoricalJourney> journeys = mainDAO.getAllJourneys();
        for (HistoricalJourney j : journeys) {
            System.out.println(j.getJourneyLength() + " " + j.getTirednessLevel());
        }
    }

    public static void main(String[] args) {
        new Test();
        //showTables();
    }
}
