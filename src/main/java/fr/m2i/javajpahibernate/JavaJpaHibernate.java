package fr.m2i.javajpahibernate;

import entities.Role;
import org.hibernate.*;
import services.RoleService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;


public class JavaJpaHibernate {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("site_commerce_pu");
        EntityManager em = emf.createEntityManager();
        RoleService roleService = new RoleService(em);


       /* //creer un  role
        em.getTransaction().begin();
        Role  admin=roleService.createRole(1L,"ADMIN","Le rôle Administrateur");
        em.getTransaction().commit();
        System.out.println("Persisted"+admin);

        //Trouver un role
        em.getTransaction().begin();
        Role role=roleService.findRole(1L);
        em.getTransaction().commit();
        System.out.println(role);

        // update
        em.getTransaction().begin();
        Role roleData = new Role();
        roleData.setDescription("Le rôle Administrateur implique de grandes responsabilités");
        roleService.updateRole(1L, roleData.getDescription(),"Le rôle Administrateur");
        em.getTransaction().commit();
        // verification
        em.getTransaction().begin();
        Role updated = roleService.findRole(1L);
        em.getTransaction().commit();
        System.out.println("Role UPDATED : " + updated);

        //Trouver les roles JPQL
        List<Role> roles=roleService.findAllJPQL();
        for(Role r:roles)
            System.out.println("Liste des Roles trouvées: Desc: "+r.getDescription()+" identifiant:"+r.getIdentifiant());


       }*/

    }




    }

