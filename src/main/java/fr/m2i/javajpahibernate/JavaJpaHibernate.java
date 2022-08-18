package fr.m2i.javajpahibernate;

import entities.Role;
import entities.Utilisateur;
import org.hibernate.*;
import services.ImplUserService;
import services.RoleService;
import services.UtilisateurService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
        /*********** USER **********/

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        UtilisateurService utilisateurService=new ImplUserService(em);

        // create
        Role role = new Role();
        role.setIdRole(1L);

        Utilisateur user = new Utilisateur( 1L,true, "Monsieur", new Date(), new Date(), new Date(), "x_x", false,"password","Bob","Marley",role);
        Utilisateur user2 = new Utilisateur( 2L,true, "Madame", new Date(), new Date(), new Date(), "y_y", false,"password","Lauren","Hill",role);
        utilisateurService.create(user);
        utilisateurService.create(user2);

        // find all
        List<Utilisateur> users = utilisateurService.getUtilisateurs();

        for (Utilisateur u : users) {
            System.out.println("Find all : " + u);
        }

        // update
        Utilisateur userData = new Utilisateur();
        userData.setActif(false);
        userData.setMarquerEffacer(true);

        try {
            userData.setDateModification(formatter.parse("11/01/2022"));
        } catch (ParseException e) {
            System.out.println("Problème de parsing : " + e.getMessage());
        }

        utilisateurService.update(2L, userData);

        // find
        Utilisateur founded = utilisateurService.findById(2L);
        System.out.println("User updated : " + founded);


        em.close();

    }




    }

