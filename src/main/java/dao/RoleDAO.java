package dao;

import dao.interfaces.IRole;
import entities.Role;
import helper.SessionHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class RoleDAO implements IRole {
    private final EntityManager entityManager;

    public RoleDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }
    @Override
    public List<Role> findAll() {
        Query findAllQuery = entityManager.createQuery("select r from Role r");
        return findAllQuery.getResultList();
    }

    @Override
    public Role findById(Long id) {
        Role founded = entityManager.find(Role.class, id);

        if (founded == null) {
            System.out.println("Attention le role avec l'id : " + id + " n'exsiste pas !");
        }

        return founded;
    }

    @Override
    public void create(Role role) {
        // Vérifier le paramètre role
        if (role == null) {
            System.out.println("L'objet role ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(role);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création du role");
            if (tx != null) {
                tx.rollback();
            }
        }

    }

    @Override
    public void update(Long id, Role roleData) {
        Role roleToUpdate = findById(id);

        if (roleToUpdate == null) {
            System.out.println("Attention le role avec l'id : " + id + " n'exsiste pas !");
            return;
        }

        roleToUpdate.copy(roleData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(roleToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la modification du role");
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    }

