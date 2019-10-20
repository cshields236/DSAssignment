package entities;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@NamedQueries({@NamedQuery(name = "DriverRecord.findAll", query = "select o from Driver o")
     })
@Entity
public class DriverRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn
    private List<HistoricalJourney> historicalJourneys = new ArrayList<HistoricalJourney>();

    public DriverRecord() {

    }

    public DriverRecord(List<HistoricalJourney> historicalJourneys) {
        this.historicalJourneys = historicalJourneys;
    }

    public List<HistoricalJourney> getHistoricalJourneys() {
        return historicalJourneys;
    }

    public void setHistoricalJourneys(List<HistoricalJourney> historicalJourneys) {
        this.historicalJourneys = historicalJourneys;
    }
}