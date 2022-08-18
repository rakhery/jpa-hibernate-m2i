package services;

import entities.Role;
import entities.Utilisateur;

import java.util.List;

public interface UserService {
    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    Role saveRole(Role role);
    void ajouterRoleUtilisateur(String identifiant,String roleName);
    Utilisateur getUtilisateur(String identifiant);
    List<Utilisateur> getUtilisateurs();
}
