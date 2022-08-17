package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_role")
    private Long id;
    @Column(name = "description", columnDefinition="TEXT")
    private String description;
    @Column(name="identifiant", length = 50)
    private String identifiant;

    public Role() {
    }

    public Role(long id, String description, String identifiant) {
        this.id = id;
        this.description = description;
        this.identifiant = identifiant;
    }

    public Long getIdRole() {
        return id;
    }

    public void setIdRole(Long idRole) {
        this.id = idRole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", identifiant='" + identifiant + '\'' +
                '}';
    }
}
