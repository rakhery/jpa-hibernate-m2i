package fr.m2i.javajpahibernate;

import entities.Role;
import services.RoleService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JavaJpaHibernate {

    public static void main(String[] args)  {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("site_commerce_pu");
        EntityManager em=emf.createEntityManager();
        RoleService roleService=new RoleService(em);
        //creer un  role
        em.getTransaction().begin();
        Role  jpa=roleService.createRole(1L,"JPA","Role JPA");
        em.getTransaction().commit();
        System.out.println("Persisted"+jpa);

    }
}
