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

        //Declarations
        mainDAO mainDAO = new mainDAO();
        List<Driver> driverList = mainDAO.getAllDrivers();
        List<HistoricalJourney> journeys = mainDAO.getAllJourneys();
        List<RealTimeJourney> realTimeJourneys = mainDAO.getAllRealTimeJourney();
        List<DriverRecord> driverRecords = mainDAO.getAllDriverRecords();
        DriverRecord rec;

        EntityManager em = emf.createEntityManager();


        //   PERSIST


        Driver driver1 = new Driver("Frank", "frank@conor.com", "hunter2");
        mainDAO.persist(driver1);


        Car car = new Car("VW", "13-D-19008", driverList);
        mainDAO.persist(car);


        HistoricalJourney historicalJourney = new HistoricalJourney("20km", "medium");
        mainDAO.persist(historicalJourney);


        Image i1 = new Image("face3", "png");
        Image i2 = new Image("face4", "png");
        Image i3 = new Image("face5", "png");
        mainDAO.persist(i1);
        mainDAO.persist(i2);
        mainDAO.persist(i3);


        Driver d = new Driver("George", "gg@gmail.com", "1234");
        mainDAO.persist(d);
        RealTimeJourney realTimeJourney = new RealTimeJourney(true, d, journeys.get(0));
        mainDAO.persist(realTimeJourney);


        Car car1 = new Car("BMW", "18-CN-199", driverList);
        mainDAO.persist(car1);


        HistoricalJourney historicalJ = new HistoricalJourney("5", "low");
        mainDAO.persist(historicalJ);


        //MERGE
        for (HistoricalJourney i : journeys) {
            i1.setHistoricalJourney(i);
            i2.setHistoricalJourney(i);

        }
        mainDAO.merge(i1);
        mainDAO.merge(i2);


        List<HistoricalJourney> historicalJourneys = mainDAO.getJourneybyTirednessLevel("medium");
        for (HistoricalJourney h : historicalJourneys) {
            h.setTirednessLevel("normal");
            mainDAO.merge(h);
        }


        List<Driver> drivers = mainDAO.getDriverByName("Frank");
        for (Driver ds : drivers) {
            ds.setEmail("frankie@yahoo.ie");
            mainDAO.merge(ds);
        }


        List<Car> cars = mainDAO.getCarbyreg("13-D-19008");
        for (Car c : cars) {
            c.setMake("Audi");
            mainDAO.merge(c);
        }




    // rec = mainDAO.getAllDriverRecords().get(0);
//        mainDAO.persist(rec);


        Driver driver = new Driver("Conor", "conor@conor.com", "hunter2");



        //REMOVE METODS
        Driver d1 =em.find(Driver.class, 3);
        em.getTransaction().begin();
        em.remove(d1);
        em.getTransaction().commit();

        HistoricalJourney h1 = em.find(HistoricalJourney.class, 3);
        em.getTransaction().begin();
        em.remove(h1);
        em.getTransaction().commit();


        Car car2 = em.find(Car.class, 3);
        em.getTransaction().begin();
        em.remove(car2);
        em.getTransaction().commit();

        Driver driverid1 = em.find(Driver.class, 2);

        em.getTransaction().begin();
        em.remove(driverid1);
        em.getTransaction().commit();

        Image image = em.find(Image.class, 2);
        em.getTransaction().begin();
        em.remove(image);
        em.getTransaction().commit();

    em.close();
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
        showAllTables();
        showWithVariable();
    }
}
