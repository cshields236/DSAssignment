package main;

import dao.mainDAO;
import entities.Driver;

public class Test {

    public Test(){
        mainDAO mainDAO = new mainDAO();
        Driver driver = new Driver("Conor","conor@conor.com", "hunter2" );

        mainDAO.persist(driver);
    }


    public static void main(String[] args) {
        new Test();
    }
}
