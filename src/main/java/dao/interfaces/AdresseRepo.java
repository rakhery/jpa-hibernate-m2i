package dao.interfaces;

import entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdresseRepo  extends JpaRepository<Adresse,Long>, JpaSpecificationExecutor<Adresse> {
}
