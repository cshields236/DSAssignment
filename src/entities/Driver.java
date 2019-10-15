package entities;

import javax.persistence.*;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;


    @OneToOne
    private DriverRecord driverDriverRecord;


    public Driver() {
    }

    public Driver(String name, String email, String password, DriverRecord drivRecord)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.driverDriverRecord = drivRecord;

    }
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
