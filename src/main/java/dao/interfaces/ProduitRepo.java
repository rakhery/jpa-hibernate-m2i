package dao.interfaces;

import entities.Adresse;
import entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProduitRepo extends JpaRepository<Produit,Long>, JpaSpecificationExecutor<Produit> {
    @Override
    List<Produit> findAll();
    //etc...

}
