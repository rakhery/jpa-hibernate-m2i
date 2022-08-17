package fr.m2i.javajpahibernate;

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
}
