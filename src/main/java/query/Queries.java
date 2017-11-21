package query;

import hibernate.model.Consoles;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;


public class Queries {

    EntityManager entityManager;

    public Queries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Queries() {

    }


    public List<Consoles> getConsoleByName(String name) {

        TypedQuery<Consoles> query = entityManager.createQuery(
                "SELECT c FROM Consoles c WHERE c.consolname LIKE :name", Consoles.class);
        return query.setParameter("name", name).getResultList();
    }

    public void getAllConsoles() throws SQLException {
        Query query = entityManager.createQuery("SELECT k FROM Cars k");
        List<Consoles> console = query.getResultList();
        for(int i=1;i<console.size();i++)
        {
            System.out.println(console.get(i).getConsoleName());
        }
    }






    public List<Consoles> getConsolesByDeveloper(String dev)
    {
        TypedQuery<Consoles> query = entityManager.createQuery(
                "SELECT c FROM Consoles c WHERE c.developer=dev", Consoles.class);
        return query.getResultList();
    }
    public List<Consoles> getAllConsolesByPage(int pagenr) {
        //calculate total number
        Query queryTotal = entityManager.createQuery
                ("Select count(f) from Consoles f");
        long countResult = (long)queryTotal.getSingleResult();

        //create query
        Query query = entityManager.createQuery("Select e FROM Consoles e");
        //set pageSize
        int pageSize = 10;
        //calculate number of pages
        int pageNumber = (int) ((countResult / pageSize) + 1);

        if (pagenr > pageNumber) pagenr = pageNumber;
        query.setFirstResult((pagenr-1) * pageSize);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

}

