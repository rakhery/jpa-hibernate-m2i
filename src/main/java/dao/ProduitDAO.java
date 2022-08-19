package dao;

import dao.interfaces.IProduit;
import entities.Produit;

import javax.persistence.EntityManager;
import java.util.List;

public class ProduitDAO implements IProduit {
    //Injection de dependance avec spring @AutoWire (Problème pour le test)
    protected EntityManager entityManager;

    //Injection de dependence
    public ProduitDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public List<Produit> findByName(String name) {
        return null;
    }

    @Override
    public List<Produit> findByDescription(String description) {
        return null;
    }

    @Override
    public List<Produit> findByPrix(double prix) {
        return null;
    }

    @Override
    public Produit findByMostQuantity() {
        return null;
    }

    @Override
    public List<Produit> findByReference(String reference) {
        return null;
    }
}
