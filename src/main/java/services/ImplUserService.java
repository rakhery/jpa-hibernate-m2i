package services;

import entities.Role;
import entities.Utilisateur;

import java.util.List;

public class ImplUserService implements UserService{
    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return null;
    }

    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public void ajouterRoleUtilisateur(String identifiant, String roleName) {

    }

    @Override
    public Utilisateur getUtilisateur(String identifiant) {
        return null;
    }

    @Override
    public List<Utilisateur> getUtilisateurs() {
        return null;
    }
}
