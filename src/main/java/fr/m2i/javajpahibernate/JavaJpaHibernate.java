package fr.m2i.javajpahibernate;

import services.RoleService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JavaJpaHibernate {

    public static void main(String[] args)  {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("test");
        EntityManager em=emf.createEntityManager();
        RoleService roleService=new RoleService(em);



    }
}
