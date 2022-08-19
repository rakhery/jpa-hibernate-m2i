package dao;

import entities.Produit;

import java.util.List;

public interface IProduit {
    List<Produit> findByNom(String name);
    List<Produit> findByDescription(String description);
    List<Produit> findByPrix(double prix);
    Produit findByMostQuantity();
    List<Produit> findByReference(String reference);

}
