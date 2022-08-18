package services;

import entities.Role;
import entities.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ImplUserService implements UtilisateurService{
    protected EntityManager entityManager;

    //Injection de dependence
    public ImplUserService(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return null;
    }

    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public void ajouterRoleUtilisateur(String identifiant, String roleName) {

    }

    @Override
    public Utilisateur findById(Long id) {
        Utilisateur founded = entityManager.find(Utilisateur.class, id);

        if (founded == null) {
            System.out.println("Attention l'utilisateur avec l'id : " + id + " n'exsiste pas !");
        }

        return founded;
    }



    @Override
    public List<Utilisateur> getUtilisateurs() {
        Query query=entityManager.createQuery(
                "select u from Utilisateur u");
        return query.getResultList();
    }

    @Override
    public void create(Utilisateur user) {
        if (user == null) {
            System.out.println("L'objet user ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(user);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création de l'utilisateur");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public void update(Long id, Utilisateur user) {
        Utilisateur userToUpdate = findById(id);

        if (userToUpdate == null) {
            System.out.println("Attention l'utilisteur avec l'id : " + id + " n'exsiste pas !");
            return;
        }

        userToUpdate.copy(user);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(userToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la modification de l'utilisateur");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }

    }
}
