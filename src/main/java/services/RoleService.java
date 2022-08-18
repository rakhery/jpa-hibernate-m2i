package services;

import entities.Role;
import org.hibernate.SQLQuery;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author : La version de @Titty est probablement  plus Pro et très defensif
 */

public class RoleService {


    protected EntityManager entityManager;

    //Injection de dependence
    public RoleService(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    public Role createRole(Long id, String description, String identifiant){
        Role roles=new Role();
        roles.setIdentifiant(identifiant);
        roles.setDescription(description);
        entityManager.persist(roles);
        return roles;
    }
    public void removeRole(Long id){
        Role role =findRole(id);
        if(role !=null){
            entityManager.remove(role);
        }
    }

    public Role findRole(Long id) {
        return entityManager.find(Role.class,id);

    }
    //Test Hibernate Query Language (HQL)
    public List<Role> findAllRole(){
        TypedQuery<Role> query=entityManager.createQuery(
                "select r from Role r", Role.class
        );
        return query.getResultList();
    }
    //Test findALL JPQL
    public List<Role> findAllJPQL(){
        Query query=entityManager.createQuery(
                "select p from Role p");
        return query.getResultList();
    }



    public Role updateRole(Long id, String description, String identifiant) {
        Role role =entityManager.find(Role.class,id);
        if(role !=null){
            role.setDescription(description);
            role.setIdentifiant(identifiant);
        }
        return role;
    }



}
