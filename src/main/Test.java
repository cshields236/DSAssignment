package main;

import dao.mainDAO;
import entities.Car;
import entities.Driver;
import entities.DriverRecord;

import java.util.List;

public class Test {

    public Test(){
        mainDAO mainDAO = new mainDAO();


        DriverRecord rec = new DriverRecord("test");
        mainDAO.persist(rec);

        Driver driver = new Driver("Conor","conor@conor.com", "hunter2", rec);

        mainDAO.persist(driver);

        Driver driver1 = new Driver("Frank","conor@conor.com", "hunter2");
        mainDAO.persist(driver1);

        List<Driver> driverList = mainDAO.getAllDrivers();


        Car car = new Car("VW", "13-D-19008", driverList);
        mainDAO.persist(car);

    }


    public static void main(String[] args) {
        new Test();
    }
}
