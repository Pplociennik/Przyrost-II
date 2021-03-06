package hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "consoles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id", "nazwa_konsoli", "model", "wersja", "wydawca", "rok_wydania"})})
public class Consoles {
    public Consoles() {
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "nazwa_konsoli")
    private String consoleName;

    @Column(name = "model")
    private String model;

    @Column(name = "wersja")
    private String version;

    @Column(name = "wydawca")
    private String developer;

    @Column(name = "rok_wydania")
    private String year;





    public Consoles(int id, String nazwa, String model, String wersja, String wydawca, String rok) {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConsoleName() {
        return consoleName;
    }

    public void setConsolname(String consolname) {
        this.consoleName = consoleName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}