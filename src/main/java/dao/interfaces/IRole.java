package dao.interfaces;

import entities.Role;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public interface IRole {
    public List<Role> findAll();
    Role findById(Long id);
    void create(Role role);
    void update(Long id, Role roleData);

}
