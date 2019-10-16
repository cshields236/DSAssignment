package entities;

import javax.persistence.*;

@NamedQueries({@NamedQuery(name = "HistoricalJourney.findAll", query = "select o from HistoricalJourney o")})

@Entity
public class HistoricalJourney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String journeyLength;
    private String tirednessLevel;


    public HistoricalJourney() {
    }

    public HistoricalJourney(String journeyLength, String tirednessLevel) {
        this.journeyLength = journeyLength;
        this.tirednessLevel = tirednessLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJourneyLength() {
        return journeyLength;
    }

    public void setJourneyLength(String journeyLength) {
        this.journeyLength = journeyLength;
    }

    public String getTirednessLevel() {
        return tirednessLevel;
    }

    public void setTirednessLevel(String tirednessLevel) {
        this.tirednessLevel = tirednessLevel;
    }
}
