package cl.cummins.mgdi.model;

import javax.persistence.*;
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
    public Vistas vista;

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

    public Vistas getVista() {
        return vista;
    }

    public void setVista(Vistas vista) {
        this.vista = vista;
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
