package hibernate.model;

import org.apache.log4j.BasicConfigurator;
import query.Queries;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();

        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {
            //taka nazwa jak w persistence.xml
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            //utworz entityManagera
            entityManager = entityManagerFactory.createEntityManager();

            //rozpocznij transakcje
            entityManager.getTransaction().begin();

            System.out.println("WYBIERZ OPCJE");
            System.out.println("1. Wyswietl konsole Xbox");
            System.out.println("2. Wyswietl wszystkie konsole");
            System.out.println("3. Wyswietl wszystkie konsole Microsoftu");

            Scanner reader = new Scanner(System.in);
            int read = reader.nextInt();

            if (read == 1) {
                Query query2 = entityManager.createQuery("SELECT k FROM Consoles k WHERE consolname='Xbox'");
                List<Consoles> console = query2.getResultList();
                for (int i = 0; i <= console.size(); i++) {
                    System.out.println(console.get(i).getId() + " " + console.get(i).getDeveloper() + " " + console.get(i).getConsoleName() + " " + console.get(i).getModel() + " " + console.get(i).getVersion() + " " + console.get(i).getYear());
                }
            } else if (read == 2) {
                Query query = entityManager.createQuery("SELECT k FROM Consoles k");
                List<Consoles> console = query.getResultList();
                for (int i = 0; i <= console.size(); i++) {
                    System.out.println(console.get(i).getId() + " " + console.get(i).getDeveloper() + " " + console.get(i).getConsoleName() + " " + console.get(i).getModel() + " " + console.get(i).getVersion() + " " + console.get(i).getYear());
                }
            } else if (read == 3) {
                Queries q3 = (Queries) new Queries().getConsolesByDeveloper("Microsoft");
                System.out.println("Done");
            }

            entityManager.getTransaction().commit();


            entityManager.close();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }


    }

}
