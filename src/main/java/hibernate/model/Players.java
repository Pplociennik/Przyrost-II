package hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "players", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id", "imie","nazwisko", "miasto", "urodzenie", "posiadana_konsola"})})
public class Players {
    public Players() {}

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "imie")
    private String name;

    @Column(name = "nazwisko")
    private String surname;

    @Column(name = "miasto")
    private String city;

    @Column(name = "urodzenie", nullable = false)
    private String birth;

    @Column(name = "posiadana_konsola", nullable = false)
    private String cons;

    public Players(int id, String imie, String nazwisko, String miasto, String urodzenie, String cons) {}

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname( String surname ) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

}