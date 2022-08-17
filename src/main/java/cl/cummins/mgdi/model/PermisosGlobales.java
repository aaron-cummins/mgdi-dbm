package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import cl.cummins.mgdi.model.Roles;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="permisos_globales")
public class PermisosGlobales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementPermisosGlobales")
    public Long id;

    /*@ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)*/
    public Long id_rol;

    /*@ManyToOne
    @JoinColumn(name = "id_vista", nullable = false)
    public Vistas vistas;*/

    @ManyToOne
    @JoinColumn(name="id_modulo", nullable = false)
    public Modulos modulo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }*/

    /*public Vistas getVistas() {
        return vistas;
    }

    public void setVistas(Vistas vistas) {
        this.vistas = vistas;
    }*/

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
