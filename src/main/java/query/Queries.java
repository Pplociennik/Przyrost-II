package query;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import hibernate.model.Consoles;
import org.apache.log4j.BasicConfigurator;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import query.QueriesTest;


public class Queries {



    public Queries() {

    }

    public static void connect() {
        BasicConfigurator.configure();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
    }

    public static List<Consoles> query1() {
        BasicConfigurator.configure();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query2 = entityManager.createQuery("SELECT k FROM Consoles k WHERE consoleName='Xbox'");
        List<Consoles> console = query2.getResultList();
        System.out.println("ID " + "Wydawca " + "Nazwa " + "Model " + "Wersja " + "Data Wydania");
        for (int i = 0; i <= console.size(); i++) {
            System.out.println(console.get(i).getId() + " " + console.get(i).getDeveloper() + " " + console.get(i).getConsoleName() + " " + console.get(i).getModel() + " " + console.get(i).getVersion() + " " + console.get(i).getYear());
        }
        entityManager.close();
        System.out.println("DONE! HAVE A NICE DAY! :)");
        return console;
    }

    public static List<Consoles> query2() {
        BasicConfigurator.configure();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT k FROM Consoles k");
        List<Consoles> console = query.getResultList();
        System.out.println("ID " + "Wydawca " + "Nazwa " + "Model " + "Wersja " + "Data Wydania");
        for (int i = 0; i <= console.size()+2; i++) {
            System.out.println(console.get(i).getId() + " " + console.get(i).getDeveloper() + " " + console.get(i).getConsoleName() + " " + console.get(i).getModel() + " " + console.get(i).getVersion() + " " + console.get(i).getYear());
        }
        System.out.println("DONE! HAVE A NICE DAY! :)");
        return console;
    }


    public static List<Consoles> query3() {
        BasicConfigurator.configure();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT k FROM Consoles k");
        List<Consoles> console = query.getResultList();
        ObjectMapper mapper = new ObjectMapper();

        //Object to JSON in file
        try {
            mapper.writeValue(new File("J:\\Desktop\\JSON.json"), console);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("DONE! HAVE A NICE DAY! :)");
        return console;
    }

    public static List<Consoles> query4() {
        BasicConfigurator.configure();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT k FROM Consoles k");
        List<Consoles> console = query.getResultList();
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File("J:\\Desktop\\XML.xml"), console);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("DONE! HAVE A NICE DAY! :)");
        return console;
    }

    public static void query5() {
        BasicConfigurator.configure();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        ObjectMapper mapperx = new ObjectMapper();
        List<Consoles> map = null;
        try {
            map = mapperx.readValue(new File("J:\\Desktop\\JSON2.json"), new TypeReference<List<Consoles>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        Consoles conj = new Consoles();
        for (int i = 0; i < map.size(); i++) {
            conj.setConsolname(map.get(i).getConsoleName());
            conj.setDeveloper(map.get(i).getDeveloper());
            conj.setModel(map.get(i).getModel());
            conj.setVersion(map.get(i).getVersion());
            conj.setYear(map.get(i).getYear());
        }
        entityManager.persist(conj);
        entityManager.getTransaction().commit();
        entityManager.merge(conj);
        System.out.println("DONE! HAVE A NICE DAY! :)");
    }

    public static void query6() {
        BasicConfigurator.configure();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        XmlMapper mapperx2 = new XmlMapper();
        List<Consoles> map2 = null;
        try {
            map2 = mapperx2.readValue(new File("J:\\Desktop\\XML2.xml"), new TypeReference<List<Consoles>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        Consoles conx = new Consoles();
        for (int i = 0; i < map2.size(); i++) {
            conx.setConsolname(map2.get(i).getConsoleName());
            conx.setDeveloper(map2.get(i).getDeveloper());
            conx.setModel(map2.get(i).getModel());
            conx.setVersion(map2.get(i).getVersion());
            conx.setYear(map2.get(i).getYear());
        }

        entityManager.merge(conx);
        System.out.println("DONE! HAVE A NICE DAY! :)");
    }

    public static List<Consoles>query7() {
        BasicConfigurator.configure();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query2 = entityManager.createQuery("SELECT k FROM Consoles k WHERE consoleName='Playstation'");
        List<Consoles> console = query2.getResultList();
        System.out.println("ID " + "Wydawca " + "Nazwa " + "Model " + "Wersja " + "Data Wydania");
        for (int i = 0; i <= console.size(); i++) {
            System.out.println(console.get(i).getId() + " " + console.get(i).getDeveloper() + " " + console.get(i).getConsoleName() + " " + console.get(i).getModel() + " " + console.get(i).getVersion() + " " + console.get(i).getYear());
        }
        System.out.println("DONE! HAVE A NICE DAY! :)");
        return console;
    }

    public static List<Consoles> query8() {
        BasicConfigurator.configure();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query4 = entityManager.createQuery("SELECT k FROM Consoles k WHERE developer='Microsoft'");
        List<Consoles> console = query4.getResultList();
        System.out.println("ID " + "Wydawca " + "Nazwa  " + "Model " + "Wersja " + "Data Wydania");
        for (int i = 0; i <= console.size(); i++) {
            System.out.println(console.get(i).getId() + " " + console.get(i).getDeveloper() + " " + console.get(i).getConsoleName() + " " + console.get(i).getModel() + " " + console.get(i).getVersion() + " " + console.get(i).getYear());
        }
        return console;
        //   System.out.println("DONE! HAVE A NICE DAY! :)");
    }

    public static List<Consoles> query9() {
        BasicConfigurator.configure();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query5 = entityManager.createQuery("SELECT k FROM Consoles k WHERE developer='Sony'");
        List<Consoles> console = query5.getResultList();
        System.out.println("ID " + "Wydawca " + "Nazwa " + "Model " + "Wersja " + "Data Wydania");
        for (int i = 0; i <= console.size(); i++) {
            System.out.println(console.get(i).getId() + " " + console.get(i).getDeveloper() + " " + console.get(i).getConsoleName() + " " + console.get(i).getModel() + " " + console.get(i).getVersion() + " " + console.get(i).getYear());
        }
        System.out.println("DONE! HAVE A NICE DAY! :)");
        return console;
    }



}




