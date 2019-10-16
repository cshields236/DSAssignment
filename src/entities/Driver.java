package entities;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({@NamedQuery(name = "Driver.findAll", query = "select o from Driver o"),
        @NamedQuery(name = "Driver.findByName", query = "select o from Driver o where o.name=:name")})

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;


    private String password;


    @OneToOne (cascade = CascadeType.ALL)
    private DriverRecord driverDriverRecord;

    @ManyToMany (cascade = CascadeType.ALL)
    private List<Car> carsList = new ArrayList<Car>();

    public Driver() {
    }

    public Driver(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;


    }
    public Driver(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;


    }
    public Driver(String name, String email, String password, DriverRecord drivRecord) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.driverDriverRecord = drivRecord;

    }

    public Driver(String name, String email, String password, ArrayList carsList) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.carsList = carsList;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DriverRecord getDriverDriverRecord() {
        return driverDriverRecord;
    }

    public void setDriverDriverRecord(DriverRecord driverDriverRecord) {
        this.driverDriverRecord = driverDriverRecord;
    }

}
