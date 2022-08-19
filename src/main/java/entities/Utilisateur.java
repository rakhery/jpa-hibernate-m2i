package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "utilisateurs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private Long idUtilisateur;
    @Column(name = "actif",columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean actif;
    @Column(length = 50)
    private String civilite;
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modification", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateModification;
    @Column(name = "date_naissance", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Column(name = "identifiant", length = 100)
    private String identifiant;
    //On souhaite pas effacer les données pour une utilisation statistique plus tard
    @Column(name = "marquer_effacer", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean marquerEffacer;
    @Column(name = "mot_passe", length = 100)
    private String motPasse;
    @Column(length = 100)
    private String nom;
    @Column(length = 100)
    private String prenom;
    @JoinColumn(name="id_role",nullable = false)
    @ManyToOne( fetch = FetchType.EAGER)
    private Role role;

    /**
     * On peut Se
     */
    @OneToMany(mappedBy = "utilisateur",cascade = CascadeType.ALL)
    private List<Adresse> adresses=new ArrayList<>();

    /*
    @author:Titty Un peu fastidieux d'ajouter l'adresse ici, il depend de la spécification bien précise

     */

    public void copy(Utilisateur userData) {
        if (userData == null) {
            return;
        }

        if (userData.getCivilite() != null) {
            this.setCivilite(userData.getCivilite());
        }

        if (userData.getNom() != null) {
            this.setNom(userData.getNom());
        }

        if (userData.getPrenom() != null) {
            this.setPrenom(userData.getPrenom());
        }

        if (userData.getIdentifiant() != null) {
            this.setIdentifiant(userData.getIdentifiant());
        }

        if (userData.getMotPasse() != null) {
            this.setMotPasse(userData.getMotPasse());
        }

        if (userData.isActif() != false) {
            this.setActif(userData.isActif());
        }

        if (userData.isMarquerEffacer() != false) {
            this.setMarquerEffacer(userData.isMarquerEffacer());
        }

        if (userData.getDateCreation() != null) {
            this.setDateCreation(userData.getDateCreation());
        }

        if (userData.getDateModification() != null) {
            this.setDateModification(userData.getDateModification());
        }

        if (userData.getDateNaissance() != null) {
            this.setDateNaissance(userData.getDateNaissance());
        }
    }
}

