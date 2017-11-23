package hibernate.model;

import hibernate.model.Consoles;
import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import query.Queries;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class Manager {

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

//            Consoles con = new Consoles();
//            con.setConsolname("Playstation");
//            con.setModel("4");
//            con.setVersion("Pro");
//            con.setDeveloper("Sony");
//            con.setYear(2016);


//          entityManager.persist(con);
//
//
            //Consoles consoles = entityManager.find(Consoles.class, con.getId());

            // Statement stat = null;
//            Query query = entityManager.createQuery("SELECT e FROM Consoles e");
//            List<Consoles> consolesList = query.getResultList();
            // ResultSet result = stat.executeQuery("SELECT consolname FROM Consoles");

//            entityManager.remove(con);

//
            // System.out.println("Konsola " + consoles.getId() + " " + consoles.getConsoleName() +     consoles.getModel() + " " + consoles.getVersion() + " " + consoles.getDeveloper() + " " + consoles.getYear());
            //zakoncz transakcje
            entityManager.getTransaction().commit();
            System.out.println("Done");

            entityManager.close();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }

    }

}