package cl.cummins.mgdi.model;

import javax.persistence.*;
import java.util.Objects;
import cl.cummins.mgdi.model.Roles;
@Entity
@Table(name="permisos_globales")
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

    @ManyToOne
    @JoinColumn(name="id_modulo", nullable = false)
    public Modulos modulo;

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

    public Modulos getModulo(){
        return this.modulo;
    }

    public void setModulo(Modulos modulo){
        this.modulo = modulo;
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
