package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity

public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adresse")
    private Long idAdresse;
    @Column(name = "code_postal",length = 100)
    private String codePostal;
    @Column(name = "pays",length = 100)
    private String pays;
    @Column(name = "principale",columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean principale;
    @Column(name = "rue",length = 100)
    private String rue;
    @Column(name = "ville",length = 100)
    private String ville;
    @JoinColumn(name="id_utilisateur",nullable = false)
    @ManyToOne( fetch = FetchType.LAZY)
    private Utilisateur utilisateur;

    public Adresse() {
    }

    /**@author Titty a imposé le constructeur, le Lombock ne fonctionne pas
     *
     * @param
     */

    public Adresse(Utilisateur utilisateur, String rue, String codePostal, String ville, String pays, Boolean principale) {
        this.utilisateur = utilisateur;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.principale = principale;
    }

    public Adresse(String rue, String codePostal, String ville, String pays, Boolean principale) {
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.principale = principale;
    }
    public void copy(Adresse addressData) {

        if (addressData == null) {
            return;
        }

        if (addressData.getRue() != null) {
            this.rue = addressData.getRue();
        }

        if (addressData.getCodePostal() != null) {
            this.codePostal = addressData.getCodePostal();
        }

        if (addressData.getVille() != null) {
            this.ville = addressData.getVille();
        }

        if (addressData.getPays() != null) {
            this.pays = addressData.getPays();
        }

        if (addressData.isPrincipale() != false) {
            this.principale = addressData.isPrincipale();
        }
    }

    public Long getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Long idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public boolean isPrincipale() {
        return principale;
    }

    public void setPrincipale(boolean principale) {
        this.principale = principale;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
