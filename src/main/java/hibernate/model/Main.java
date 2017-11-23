package hibernate.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.log4j.BasicConfigurator;
import query.Queries;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static query.Queries.*;

public class Main {

    public static List<Consoles> getAllConsolesByPage(int pagenr) {
        BasicConfigurator.configure();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query querypage = entityManager.createQuery("SELECT COUNT(c.id) FROM Consoles c");
        int pageNumber = 1;
        int pageSize = 10;
        querypage.setFirstResult((pageNumber - 1) * pageSize);
        querypage.setMaxResults(pageSize);
        List<Consoles> consolespage = querypage.getResultList();
        for (int i = 0; i < consolespage.size(); i++) {
            System.out.println(consolespage.get(i).getId() + " " + consolespage.get(i).getDeveloper() + " " + consolespage.get(i).getConsoleName() + " " + consolespage.get(i).getModel() + " " + consolespage.get(i).getVersion() + " " + consolespage.get(i).getYear());
        }
        return consolespage;
    }

    public static void main(String[] args) {
//        BasicConfigurator.configure();
//
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
        System.out.println("3. Zapisz wszystko do pliku JSON");
        System.out.println("4. Zapisz wszystko do pliku XML");
        System.out.println("5. Wyslij JSON do bazy danych");
        System.out.println("6. Wyslij XML do bazy danych");
        System.out.println("7. Wyswietl konsole Playstation");
        System.out.println("8. Wyswietl konsole Microsoftu");
        System.out.println("9. Wyswietl konsole Sony");
        System.out.println("0. Wyswietl wszystkie konsole (zapytanie stronnicowane)");

        Scanner reader = new Scanner(System.in);
        int read = reader.nextInt();

        if (read == 1) {
            query1();

        } else if (read == 2) {
            query2();

        } else if (read == 3) {
            query3();
        } else if (read == 4) {
            query4();
        } else if (read == 5) {
            query5();
        } else if (read == 6) {
            query6();

        } else if (read == 7) {
            query7();
        } else if (read == 8) {
            query8();
        } else if (read == 9) {

            query9();
        } else {
          getAllConsolesByPage(1);
        }


        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }
    }
}




