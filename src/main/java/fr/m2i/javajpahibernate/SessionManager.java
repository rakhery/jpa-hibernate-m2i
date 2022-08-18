package fr.m2i.javajpahibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Patron de conception Fabrique
public class SessionManager {
    public static EntityManager getEntityManager(){
        EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("site_commerce_pu");
        EntityManager entityManager=managerFactory.createEntityManager();
        return entityManager;
    }
    public static Session getCurrentSessionFromConfig() {
        // SessionFactory in Hibernate 5 example
        Configuration config = new Configuration();
        config.configure();
        // local SessionFactory bean created
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        return session;
    }
}
