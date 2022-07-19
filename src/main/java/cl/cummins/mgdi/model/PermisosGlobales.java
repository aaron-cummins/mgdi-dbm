package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class PermisosGlobales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    public Roles rol;

    @ManyToOne
    @JoinColumn(name = "id_vista", nullable = false)
    public Vistas vistas;

    /*@OneToMany(mappedBy = "permisosGlobales", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Vistas> vistas;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Vistas getVistas() {
        return vistas;
    }

    public void setVistas(Vistas vistas) {
        this.vistas = vistas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermisosGlobales that = (PermisosGlobales) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
