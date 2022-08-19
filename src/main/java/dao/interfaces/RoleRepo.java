package dao.interfaces;

import entities.Adresse;
import entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepo extends JpaRepository<Role,Long>, JpaSpecificationExecutor<Role> {
}
