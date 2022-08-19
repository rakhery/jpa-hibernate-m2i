package dao;

import entities.Adresse;
import entities.Utilisateur;

import java.util.List;

public interface IAdresse {
    public List<Adresse> findAll();
    public Adresse findById(Long id);
    public List<Adresse> findByUtilisateur(Utilisateur user);
    public void create(Adresse adresseToCreate);
    public void update(Long id, Adresse adresseData);

}