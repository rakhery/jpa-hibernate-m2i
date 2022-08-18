package services;

import entities.Role;
import entities.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    Role saveRole(Role role);
    void ajouterRoleUtilisateur(String identifiant,String roleName);
    Utilisateur findById(Long id);
    List<Utilisateur> getUtilisateurs();
    void create(Utilisateur user);
    public void update(Long id,Utilisateur user);
}
