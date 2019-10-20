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

    @OneToMany
    private List<HistoricalJourney> journeyList = new ArrayList<HistoricalJourney>();

    public DriverRecord() {

    }

    public DriverRecord(ArrayList journeyList) {

        this.journeyList = journeyList;

    }


    public List<HistoricalJourney> getJourneyList() {
        return journeyList;
    }

    public void setJourneyList(List<HistoricalJourney> journeyList) {
        this.journeyList = journeyList;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}