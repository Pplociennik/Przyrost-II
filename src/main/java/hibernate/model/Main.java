package hibernate.model;

import com.fasterxml.jackson.core.type.TypeReference;
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
            System.out.println("5. Wyslij JSON do bazy danych");
            System.out.println("6. Wyslij XML do bazy danych");
            System.out.println("7. Wyswietl konsole Playstation");
            System.out.println("8. Wyswietl konsole Microsoftu");
            System.out.println("9. Wyswietl konsole Sony");

            Scanner reader = new Scanner(System.in);
            int read = reader.nextInt();

            if (read == 1) {
                Query query2 = entityManager.createQuery("SELECT k FROM Consoles k WHERE consolname='Xbox'");
                List<Consoles> console = query2.getResultList();
                System.out.println("ID " + "Wydawca " + "Nazwa " + "Model " + "Wersja " + "Data Wydania");
                for (int i = 0; i <= console.size(); i++) {
                    System.out.println(console.get(i).getId() + " " + console.get(i).getDeveloper() + " " + console.get(i).getConsoleName() + " " + console.get(i).getModel() + " " + console.get(i).getVersion() + " " + console.get(i).getYear());
                }
            } else if (read == 2) {
                Query query = entityManager.createQuery("SELECT k FROM Consoles k");
                List<Consoles> console = query.getResultList();
                System.out.println("ID " + "Wydawca " + "Nazwa " + "Model " + "Wersja " + "Data Wydania");
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

            else if (read == 5) {
                ObjectMapper mapperx = new ObjectMapper();
                List<Consoles> map = mapperx.readValue(new File("C:\\Users\\Win10\\Desktop\\JSON2.json"), new TypeReference<List<Consoles>>() {});

                Consoles conj = new Consoles();
                for(int i = 0; i < map.size(); i++) {
                    conj.setConsolname(map.get(i).getConsoleName());
                    conj.setDeveloper(map.get(i).getDeveloper());
                    conj.setModel(map.get(i).getModel());
                    conj.setVersion(map.get(i).getVersion());
                    conj.setYear(map.get(i).getYear());
                }
                entityManager.persist(conj);
                entityManager.getTransaction().commit();
                entityManager.merge(conj);
            }

            else if (read == 6) {
                XmlMapper mapperx2 = new XmlMapper();
                List<Consoles> map2 = mapperx2.readValue(new File("C:\\Users\\Win10\\Desktop\\XML2.xml"), new TypeReference<List<Consoles>>() {});

                Consoles conx = new Consoles();
                for(int i = 0; i < map2.size(); i++) {
                    conx.setConsolname(map2.get(i).getConsoleName());
                    conx.setDeveloper(map2.get(i).getDeveloper());
                    conx.setModel(map2.get(i).getModel());
                    conx.setVersion(map2.get(i).getVersion());
                    conx.setYear(map2.get(i).getYear());
                }

                entityManager.merge(conx);
            }

            else if (read == 7) {
                Query query2 = entityManager.createQuery("SELECT k FROM Consoles k WHERE consolname='Playstation'");
                List<Consoles> console = query2.getResultList();
                System.out.println("ID " + "Wydawca " + "Nazwa " + "Model " + "Wersja " + "Data Wydania");
                for (int i = 0; i <= console.size(); i++) {
                    System.out.println(console.get(i).getId() + " " + console.get(i).getDeveloper() + " " + console.get(i).getConsoleName() + " " + console.get(i).getModel() + " " + console.get(i).getVersion() + " " + console.get(i).getYear());
                }
            }

            else if (read == 8)
            {
                Query query4 = entityManager.createQuery("SELECT k FROM Consoles k WHERE developer='Microsoft'");
                List<Consoles> console = query4.getResultList();
                System.out.println("ID " + "Wydawca " + "Nazwa  " + "Model " + "Wersja " + "Data Wydania");
                for (int i = 0; i <= console.size(); i++) {
                    System.out.println(console.get(i).getId() + " " + console.get(i).getDeveloper() + " " + console.get(i).getConsoleName() + " " + console.get(i).getModel() + " " + console.get(i).getVersion() + " " + console.get(i).getYear());
                }
            }

            else if(read == 9)
            {
                Query query5 = entityManager.createQuery("SELECT k FROM Consoles k WHERE developer='Sony'");
                List<Consoles> console = query5.getResultList();
                System.out.println("ID " + "Wydawca " + "Nazwa " + "Model " + "Wersja " + "Data Wydania");
                for (int i = 0; i <= console.size(); i++) {
                    System.out.println(console.get(i).getId() + " " + console.get(i).getDeveloper() + " " + console.get(i).getConsoleName() + " " + console.get(i).getModel() + " " + console.get(i).getVersion() + " " + console.get(i).getYear());
                }
            }

            else
            {}



        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }
    }
}




