package hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import query.Queries;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.security.auth.login.Configuration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        //taka nazwa jak w persistence.xml
        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        //utworz entityManagera
        entityManager = entityManagerFactory.createEntityManager();

//        Configuration cfg = new Configuration;
//        cfg.getAppConfigurationEntry("persistance.xml");
//        SessionFactory sf = cfg.
//        Session s entityManager.op
        //rozpocznij transakcje
        entityManager.getTransaction().begin();

        Consoles con = (Consoles) entityManager.createQuery("SELECT c FROM Consoles WHERE c.wydawca='Microsoft'");

    }

}
