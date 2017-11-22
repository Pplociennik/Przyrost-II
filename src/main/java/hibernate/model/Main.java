package hibernate.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.log4j.BasicConfigurator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

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
            System.out.println("3. Zapisz wszystko do pliku JSON");
            System.out.println("4. Zapisz wszystko do pliku XML");

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
                Query query = entityManager.createQuery("SELECT k FROM Consoles k");
                List<Consoles> console = query.getResultList();
                ObjectMapper mapper = new ObjectMapper();

                //Object to JSON in file
                try {
                    mapper.writeValue(new File("C:\\Users\\Win10\\Desktop\\JSON.json"), console);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else if (read == 4)
            {
                Query query = entityManager.createQuery("SELECT k FROM Consoles k");
                List<Consoles> console = query.getResultList();
                XmlMapper xmlMapper = new XmlMapper();
                xmlMapper.writeValue(new File("C:\\Users\\Win10\\Desktop\\XML.xml"), console);
                }



        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }
    }
}




