package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

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
    @Column(name = "date_modification")
    private Date dateModification;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    private String identifiant;
    //On souhaite pas effecer les données pour une utilisation statistique plustard
    @Column(name = "marquer_effacer", columnDefinition = "TINYINT(1) DEFAULT")
    private boolean marquerEffacer;
    @Column(name = "mot_passe", length = 100)
    private String motPasse;
    @Column(length = 100)
    private String nom;
    @Column(length = 100)
    private String prenom;
    @JoinColumn(name="id_role",nullable = false)
    @ManyToOne( fetch = FetchType.LAZY)
    private Role role;

}
