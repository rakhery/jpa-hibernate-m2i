package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
