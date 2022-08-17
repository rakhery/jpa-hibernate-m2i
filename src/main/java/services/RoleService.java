package services;

import entities.Role;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public void removeRoles(Long id){
        Role role =findRoles(id);
        if(role !=null){
            entityManager.remove(role);
        }
    }

    public Role findRoles(Long id) {
        return entityManager.find(Role.class,id);

    }
    public List<Role> findAllRole(){
        TypedQuery<Role> query=entityManager.createQuery(
                "select t from Role t", Role.class
        );
        return query.getResultList();
    }

    public Role updateRoles(Long id, String description, String identifiant) {
        Role role =entityManager.find(Role.class,id);
        if(role !=null){
            role.setDescription(description);
            role.setIdentifiant(identifiant);
        }
        return role;
    }



}
