package entities;

import javax.persistence.*;


@NamedQueries({@NamedQuery(name = "RealTimeJourney.findAll", query = "select o from RealTimeJourney o")})

@Entity
public class RealTimeJourney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean tired;
    @OneToOne
    private  Driver driver;
    @OneToOne
    private HistoricalJourney historicalJourney;


    public RealTimeJourney() {
    }

    public RealTimeJourney(boolean tired, Driver driver, HistoricalJourney historicalJourney) {
        this.tired = tired;
        this.driver = driver;
        this.historicalJourney = historicalJourney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTired() {
        return tired;
    }

    public void setTired(boolean tired) {
        this.tired = tired;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public HistoricalJourney getHistoricalJourney() {
        return historicalJourney;
    }

    public void setHistoricalJourney(HistoricalJourney historicalJourney) {
        this.historicalJourney = historicalJourney;
    }
}
