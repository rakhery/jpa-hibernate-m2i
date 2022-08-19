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
    @Column(name = "id_utilisateur")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;

    @JoinColumn(name = "id_role", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    @OneToMany(mappedBy = "utilisateur", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Adresse> adresses;

    @Column(name = "civilite", length = 100)
    private String civilite;

    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "prenom", length = 100)
    private String prenom;

    @Column(name = "identifiant", length = 100)
    private String identifiant;

    @Column(name = "mot_passe", length = 100)
    private String motPasse;

    @Column(name = "actif", columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean actif;

    @Column(name = "marquer_effacer", columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean marquerEffacer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modification", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateModification;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_naissance", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateNaissance;

    /**@author Titty a imposé le constructeur, le Lombock ne fonctionne pas
     *
     * @param userData
     */
    public Utilisateur(Role role, String civilite, String nom, String prenom,
                       String identifiant, String motPasse, Boolean actif, Boolean marquerEffacer,
                       Date dateCreation, Date dateModification, Date dateNaissance) {
        this.role = role;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.motPasse = motPasse;
        this.actif = actif;
        this.marquerEffacer = marquerEffacer;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.dateNaissance = dateNaissance;
    }


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

        if (userData.getActif() != false) {
            this.setActif(userData.getActif());
        }

        if (userData.marquerEffacer != false) {
            this.setMarquerEffacer(userData.getMarquerEffacer());
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
    public void addAddress(Adresse address) {
        if (adresses == null) {
            adresses = new ArrayList<>();
        }

        adresses.add(address);
        address.setUtilisateur(this);
    }
    public void removeAddress(Adresse address) {
        address.setUtilisateur(null);

        if (adresses != null) {
            adresses.remove(address);
        }
    }
}

