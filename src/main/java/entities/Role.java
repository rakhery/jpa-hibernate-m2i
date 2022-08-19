package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="roles")
public class Role implements Serializable {
    @Id
    @Column(name = "id_role")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @Column(name = "identifiant", length = 50)
    private String identifiant;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Role() {
    }

    public Role( String description, String identifiant) {
        this.description = description;
        this.identifiant = identifiant;
    }
    /**
    public Role(long id, String description, String identifiant) {
        this.idRole = id;
        this.description = description;
        this.identifiant = identifiant;
    }
   **/
    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
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
        return "Role{" + "idRole=" + idRole + ", identifiant=" + identifiant + ", description=" + description + '}';
    }

    public void copy(Role roleData) {

        if (roleData == null) {
            return;
        }

        if (roleData.getIdentifiant() != null) {
            this.setIdentifiant(roleData.getIdentifiant());
        }

        if (roleData.getDescription() != null) {
            this.setDescription(roleData.getDescription());
        }
    }
}
