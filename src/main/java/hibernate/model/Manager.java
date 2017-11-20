package hibernate.model;

import hibernate.model.Consoles;
import query.Queries;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class Manager {

    public static void main(String[] args) {

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

            Consoles con = new Consoles();
            con.setConsolname("Xbox");
            con.setModel("360");
            con.setVersion("Core");
            con.setDeveloper("Microsoft");
            con.setYear(2006);

            Consoles con1 = new Consoles();
            con1.setConsolname("Xbox");
            con1.setModel("360");
            con1.setVersion("Premium");
            con1.setDeveloper("Microsoft");
            con1.setYear(2006);

            Consoles con2 = new Consoles();
            con2.setConsolname("Xbox");
            con2.setModel("360");
            con2.setVersion("Slim");
            con2.setDeveloper("Microsoft");
            con2.setYear(2010);

            Consoles con3 = new Consoles();
            con3.setConsolname("Xbox");
            con3.setModel("ONE");
            con3.setVersion("Core");
            con3.setDeveloper("Microsoft");
            con3.setYear(2013);

            Consoles con4 = new Consoles();
            con4.setConsolname("Xbox");
            con4.setModel("ONE");
            con4.setVersion("S");
            con4.setDeveloper("Microsoft");
            con4.setYear(2016);

            Consoles con5 = new Consoles();
            con5.setConsolname("Xbox");
            con5.setModel("ONE");
            con5.setVersion("S");
            con5.setDeveloper("Microsoft");
            con5.setYear(2017);



            entityManager.persist(con);
            entityManager.persist(con1);
            entityManager.persist(con2);
            entityManager.persist(con3);
            entityManager.persist(con4);
            entityManager.persist(con5);

            Consoles consoles = entityManager.find(Consoles.class, con.getId());
            Consoles consoles1 = entityManager.find(Consoles.class, con.getId());
            Consoles consoles2 = entityManager.find(Consoles.class, con.getId());
            Consoles consoles3 = entityManager.find(Consoles.class, con.getId());
            Consoles consoles4 = entityManager.find(Consoles.class, con.getId());
            Consoles consoles5 = entityManager.find(Consoles.class, con.getId());

            Query query = entityManager.createQuery("SELECT Xbox FROM Consolename");
            List<Consoles> consolesList = query.getResultList();

//            entityManager.remove(con);
//            entityManager.remove(con1);
//            entityManager.remove(con2);
//            entityManager.remove(con3);
//            entityManager.remove(con4);
//            entityManager.remove(con5);

            System.out.println("dasdasdasds");
            System.out.println("Konsola " + consoles.getId() + " " + consoles.getConsoleName() +     consoles.getModel() + " " + consoles.getVersion());

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