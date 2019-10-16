package entities;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String fileType;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
    private HistoricalJourney historicalJourney;

    public Image( String title, String fileType) {
        this.title = title;
        this.fileType = fileType;
    }
    public Image( String title, String fileType, HistoricalJourney historicalJourney) {
        this.title = title;
        this.fileType = fileType;
        this.historicalJourney = historicalJourney;


    }


    public Image() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public HistoricalJourney getHistoricalJourney() {
        return historicalJourney;
    }

    public void setHistoricalJourney(HistoricalJourney historicalJourney) {
        this.historicalJourney = historicalJourney;
    }

}


