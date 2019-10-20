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
        List<Driver> driverList = mainDAO.getAllDrivers();
        List<HistoricalJourney> journeys = mainDAO.getAllJourneys();
        List<RealTimeJourney> realTimeJourneys = mainDAO.getAllRealTimeJourney();
        List<DriverRecord> driverRecords = mainDAO.getAllDriverRecords();

        EntityManager em = emf.createEntityManager();


        //   PERSIST
//
//         driver = new Driver("Conor","conor@conor.com", "hunter2", rec);
//
//        mainDAO.persist(driver);
//
//        Driver driver1 = new Driver("Frank","frank@conor.com", "hunter2");
//        mainDAO.persist(driver1);
//

//
//
//        Car car = new Car("VW", "13-D-19008", driverList);
//        mainDAO.persist(car);

//
//        HistoricalJourney historicalJourney = new HistoricalJourney("20km", "medium");
//        mainDAO.persist(historicalJourney);
//

////
//        DriverRecord rec;
//        rec = new DriverRecord(journeys);
//        mainDAO.persist(rec);
//
////        Image i1 = new Image("face3", "png");
////        Image i2 = new Image("face4", "png");
////        Image i3 = new Image("face5", "png");
////        mainDAO.persist(i1);
////        mainDAO.persist(i2);
////        mainDAO.persist(i3);
//        for (HistoricalJourney i : journeys) {
//            i1.setHistoricalJourney(i);
//            i2.setHistoricalJourney(i);
//
//        }
////        mainDAO.merge(i1);
////        mainDAO.merge(i2);


        //REMOVE


        //MERGE
        ///Driver driver1 = new Driver(4, "John", "completely@email.com", "afwewef");

//        em.getTransaction().begin();

//        mainDAO.remove(driver1);
//        em.close();

        //    Driver driver = em.find(Driver.class, 1);
//
//        em.getTransaction().begin();
//        em.remove(driver);
//        em.getTransaction().commit();
//        Driver d = new Driver("George", "gg@gmail.com", "1234");
//        mainDAO.persist(d);
//        RealTimeJourney realTimeJourney = new RealTimeJourney(true, d, journeys.get(0));
//        mainDAO.persist(realTimeJourney);
//
//        List<Car> cars = mainDAO.getCarbyreg("13-D-19008");
//        for (Car c : cars) {
//            c.setMake("Audi");
//            mainDAO.merge(c);
//        }

//        Car car = new Car("BMW", "18-CN-199", driverList);
//        mainDAO.persist(car);

//        Car car1 = em.find(Car.class, 2);
//        em.getTransaction().begin();
//        em.remove(car1);
//        em.getTransaction().commit();

//        List<Driver> drivers = mainDAO.getDriverByName("Frank");
//        for (Driver driver1 : drivers) {
//         driver1.setEmail("frankie@yahoo.ie");
//         mainDAO.merge(driver1);
//        }


//        List<HistoricalJourney> historicalJourneys = mainDAO.getJourneybyTirednessLevel("medium");
//        for (HistoricalJourney h : historicalJourneys) {
//            h.setTirednessLevel("normal");
//            mainDAO.merge(h);
//        }

//        HistoricalJourney historicalJ = new HistoricalJourney("5", "low");
//        mainDAO.persist(historicalJ);
//


        HistoricalJourney h1 = em.find(HistoricalJourney.class, 4);
        em.getTransaction().begin();
        em.remove(h1);
        em.getTransaction().commit();




    }


    public static void showAllTables() {


        mainDAO mainDAO = new mainDAO();
        List<HistoricalJourney> journeys = mainDAO.getAllJourneys();
        for (HistoricalJourney j : journeys) {
            System.out.println("Journey: " + j.getJourneyLength() + " " + j.getTirednessLevel());
        }

        List<Car> cars = mainDAO.getAllCars();
        for (Car c : cars) {
            System.out.println("Car: " + c.getMake() + " " + c.getReg());
        }

        List<Driver> drivers = mainDAO.getAllDrivers();
        for (Driver d : drivers) {
            System.out.println("Driver: " + d.getName() + " E-mail: " + d.getEmail());
        }

        List<Image> images = mainDAO.getAllImages();
        for (Image i : images) {
            System.out.println("Image: " + i.getTitle() + " File Type: " + i.getFileType());
        }


        List<RealTimeJourney> realTimeJourneys = mainDAO.getAllRealTimeJourney();
        for (RealTimeJourney r : realTimeJourneys) {
            System.out.println("ID: " + r.getDriver() + " Tired?: " + r.isTired());
        }


    }


    public static void showWithVariable() {
        // Get By Parameter
        List<Car> cars = mainDAO.getCarbyreg("13-D-19008");
        for (Car c : cars) {
            System.out.println("Car manufacturer: " + c.getMake() + " Registration: " + c.getReg());
        }


        List<Driver> drivers = mainDAO.getDriverByName("Frank");
        for (Driver d : drivers) {
            System.out.println("Driver: " + d.getName() + " E-mail: " + d.getEmail());
        }


        List<HistoricalJourney> journeys = mainDAO.getJourneybyTirednessLevel("high");
        for (HistoricalJourney j : journeys) {
            System.out.println(j.getId() + " " + j.getTirednessLevel());
        }

        List<Image> images = mainDAO.getImageByTitle("face3");
        for (Image i : images) {
            System.out.println("Image: " + i.getTitle() + " File Type: " + i.getFileType());
        }
    }

    public static void main(String[] args) {
        new Test();
        //showAllTables();
        //showWithVariable();
    }
}
