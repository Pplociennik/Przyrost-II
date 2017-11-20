package hibernate.model;

import query.Queries;

import java.util.List;

public class Main {
    public static void main(String[] args) {
    List<Consoles> Xbox = new Queries().getConsoleByName("Xbox");
    System.out.println(Xbox);
    }

}
