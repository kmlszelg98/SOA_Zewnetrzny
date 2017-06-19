package system;

import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import javax.persistence.metamodel.EntityType;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Kamil on 11.06.2017.
 */
public class Database {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public ArrayList<Place> main(){
        System.out.println("OBLICZAM");
        ArrayList<Place> places = new ArrayList<>();
        final Session session = getSession();

        final Query query = session.createQuery("from Place");
        for (Object o : query.list()) {
            Place t = (Place) o;
            places.add(t);
        }
        return places;
    }
}