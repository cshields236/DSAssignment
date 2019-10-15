package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DriverRecord {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pastJourneys;

    public DriverRecord(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPastJourneys() {
        return pastJourneys;
    }

    public void setPastJourneys(String pastJourneys) {
        this.pastJourneys = pastJourneys;
    }

    public DriverRecord(String pastJourneys) {
        this.pastJourneys = pastJourneys;
    }
}
