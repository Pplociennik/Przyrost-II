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


public class Queries {

    EntityManager entityManager;

    public Queries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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

    public static void query1() {
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
        System.out.println("DONE! HAVE A NICE DAY! :)");
    }

    public static void query2() {
        BasicConfigurator.configure();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT k FROM Consoles k");
        List<Consoles> console = query.getResultList();
        System.out.println("ID " + "Wydawca " + "Nazwa " + "Model " + "Wersja " + "Data Wydania");
        for (int i = 0; i <= console.size(); i++) {
            System.out.println(console.get(i).getId() + " " + console.get(i).getDeveloper() + " " + console.get(i).getConsoleName() + " " + console.get(i).getModel() + " " + console.get(i).getVersion() + " " + console.get(i).getYear());
        }
        System.out.println("DONE! HAVE A NICE DAY! :)");
    }

    public static void query3() {
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
            mapper.writeValue(new File("C:\\Users\\Win10\\Desktop\\JSON.json"), console);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("DONE! HAVE A NICE DAY! :)");
    }

    public static void query4() {
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
            xmlMapper.writeValue(new File("C:\\Users\\Win10\\Desktop\\XML.xml"), console);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("DONE! HAVE A NICE DAY! :)");
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
            map = mapperx.readValue(new File("C:\\Users\\Win10\\Desktop\\JSON2.json"), new TypeReference<List<Consoles>>() {
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
            map2 = mapperx2.readValue(new File("C:\\Users\\Win10\\Desktop\\XML2.xml"), new TypeReference<List<Consoles>>() {
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

    public static void query7() {
        BasicConfigurator.configure();
        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query2 = entityManager.createQuery("SELECT k FROM Consoles k WHERE consolname='Playstation'");
        List<Consoles> console = query2.getResultList();
        System.out.println("ID " + "Wydawca " + "Nazwa " + "Model " + "Wersja " + "Data Wydania");
        for (int i = 0; i <= console.size(); i++) {
            System.out.println(console.get(i).getId() + " " + console.get(i).getDeveloper() + " " + console.get(i).getConsoleName() + " " + console.get(i).getModel() + " " + console.get(i).getVersion() + " " + console.get(i).getYear());
        }
        System.out.println("DONE! HAVE A NICE DAY! :)");
    }

    public static void query8() {
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
        System.out.println("DONE! HAVE A NICE DAY! :)");
    }

    public static void query9() {
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
    }


    public List<Consoles> getAllConsolesByPage(int pagenr) {
        //calculate total number
        Query queryTotal = entityManager.createQuery
                ("Select count(f) from Consoles f");
        long countResult = (long) queryTotal.getSingleResult();

        //create query
        Query query = entityManager.createQuery("Select e FROM Consoles e");
        //set pageSize
        int pageSize = 10;
        //calculate number of pages
        int pageNumber = (int) ((countResult / pageSize) + 1);

        if (pagenr > pageNumber) pagenr = pageNumber;
        query.setFirstResult((pagenr - 1) * pageSize);
        query.setMaxResults(pageSize);

        List<Consoles> c = query.getResultList();
        for (int i = 0; i <= c.size(); i++) {
            System.out.println(c.get(i).getId() + " " + c.get(i).getDeveloper() + " " + c.get(i).getConsoleName() + " " + c.get(i).getModel() + " " + c.get(i).getVersion() + " " + c.get(i).getYear());
        }

        return query.getResultList();
    }


}

