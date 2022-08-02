package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementRoles")
    public Long id;

    @Column(length = 250)
    public String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "rol", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<PermisosGlobales> permisosGlobales;

    @Column()
    public Timestamp created_at;
    @Column()
    public Timestamp updated_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public List<PermisosGlobales> getPermisosGlobales() {
        return permisosGlobales;
    }

    public void setPermisosGlobales(List<PermisosGlobales> permisosGlobales) {
        this.permisosGlobales = permisosGlobales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return Objects.equals(id, roles.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
