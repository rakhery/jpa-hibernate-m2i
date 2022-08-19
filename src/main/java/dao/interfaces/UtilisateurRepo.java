package dao.interfaces;

import entities.Adresse;
import entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UtilisateurRepo extends JpaRepository<Utilisateur,Long>, JpaSpecificationExecutor<Utilisateur> {

}
