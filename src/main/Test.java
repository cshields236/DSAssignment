package main;

import dao.mainDAO;
import entities.Driver;
import entities.DriverRecord;

public class Test {

    public Test(){
        mainDAO mainDAO = new mainDAO();


        DriverRecord rec = new DriverRecord("test");
        mainDAO.persist(rec);

        Driver driver = new Driver("Conor","conor@conor.com", "hunter2", rec);

        mainDAO.persist(driver);
    }


    public static void main(String[] args) {
        new Test();
    }
}
