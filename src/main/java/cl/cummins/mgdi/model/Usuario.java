package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(length = 10)
    public String rut;
    @Column(length = 10)
    public String uid;
    @Column(length = 250)
    public String nombres;
    @Column(length = 250)
    public String apellidos;
    @Column(length = 250)
    public String correo;
    @Column(length = 250)
    public String telefono;
    @Column(length = 250)
    public String anexo;

    /*@ManyToOne
    @JoinColumn(name = "id")
    @NotFound(action = NotFoundAction.IGNORE)*/
    @Column()
    public Integer id_cargo;

    @Column()
    public Integer id_lugar_trabajo;
    @Column()
    public Timestamp created_at;
    @Column()
    public Timestamp updated_at;
    @Column()
    public boolean activo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public Integer getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }

    public Integer getId_lugar_trabajo() {
        return id_lugar_trabajo;
    }

    public void setId_lugar_trabajo(Integer id_lugar_trabajo) {
        this.id_lugar_trabajo = id_lugar_trabajo;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
