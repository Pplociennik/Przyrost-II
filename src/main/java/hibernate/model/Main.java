package hibernate.model;

import query.Queries;

import java.util.List;

public class Main {
    public void main() {
    List<Consoles> Xbox = new Queries().getConsoleByName("Xbox");
    }

}
