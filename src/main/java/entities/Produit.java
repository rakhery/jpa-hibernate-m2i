package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity

public class Produit {
    @Id
    @Column(name = "id_produit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    @Column(name = "active", columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean active;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "nom", length = 100)
    private String nom;
    @Column(name = "prix")
    private Float prix;
    @Column(name = "reference", length = 100)
    private String reference;
    @Column(name = "stock", length = 11)
    private Integer stock;

    @Override
    public String toString() {
        return "Produit{" +
                "idProduit=" + idProduit +
                ", active=" + active +
                ", description='" + description + '\'' +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", reference='" + reference + '\'' +
                ", stock=" + stock +
                '}';
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
