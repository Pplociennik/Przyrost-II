package hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "Consoles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id", "nazwa_konsoli","model", "wersja", "wydawca", "rok_wydania"})})
public class Consoles {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "nazwa_konsoli")
    private String consolname;

    @Column(name = "model")
    private String model;

    @Column(name = "wersja")
    private String version;

    @Column(name = "wydawca")
    private String developer;

    @Column(name = "rok_wydania")
    private int year;

    public Consoles() {}

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getConsoleName() {
        return consolname;
    }

    public void setConsolname( String consolname ) {
        this.consolname = consolname;
    }

    public String getModel() {
        return model;
    }

    public void setModel( String model ) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion( String version ) {
        this.version = version;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public int getYear() {
        return year;
    }

    public void setYear( int year ) {
        this.year = year;
    }
}