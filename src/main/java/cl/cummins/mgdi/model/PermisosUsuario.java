package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

import cl.cummins.mgdi.model.Roles;

@Entity
public class PermisosUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "id_lugar_trabajo")
    public Integer lugarTrabajo;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_usuario", nullable = false)
    public Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    public Roles roles;



    @Column()
    public Integer versionMotor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(Integer lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Integer getVersionMotor() {
        return versionMotor;
    }

    public void setVersionMotor(Integer versionMotor) {
        this.versionMotor = versionMotor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermisosUsuario that = (PermisosUsuario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
