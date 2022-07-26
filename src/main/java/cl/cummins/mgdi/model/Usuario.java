package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementUsuario")
    @GenericGenerator(name = "incrementUsuario", strategy = "increment")
    public Long id;

    @NotBlank(message = "El Rut es obligatorio")
    @Column(length = 10)
    public String rut;

    @NotBlank(message = "El UID es obligatorio") @Size(min = 3, max = 250, message = "El UID debe ser un valor entre 3 y 10 caracteres")
    @Column(length = 10)
    public String uid;

    @NotBlank(message = "El nombre es obligatorio") @Size(min = 3, max = 250, message = "El nombre debe ser un valor entre 3 y 250 caracteres")
    @Column(length = 250)
    public String nombres;

    @NotBlank(message = "El apellido es obligatorio") @Size(min = 3, max = 250, message = "El apelliido debe ser un valor entre 3 y 250 caracteres")
    @Column(length = 250)
    public String apellidos;

    @NotBlank(message = "El correo es obligatorio")  @Size(min = 10, max = 250, message = "El email debe tener al menos 10 caracteres")
    @Email(message = "El correo enviado no es un formato válido")
    @Column(length = 250)
    public String correo;

    @Size(min = 3, max = 10, message = "El telefono debe tener al menos 8 caracteres")
    @Column(length = 250)
    public String telefono;
    @Column(length = 250)
    public String anexo;

    public String password;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private Cargo cargo;

    //@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private Set<PermisosUsuario> permisos;

//    @OneToMany(mappedBy =  "id")
//    public Set<LugarTrabajo> lugarTrabajos;

    @Column()
    public Timestamp created_at;
    @Column()
    public Timestamp updated_at;
    @Column()
    public boolean activo;


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getRut() {
//        return rut;
//    }
//
//    public void setRut(String rut) {
//        this.rut = rut;
//    }
//
//    public String getUid() {
//        return uid;
//    }
//
//    public void setUid(String uid) {
//        this.uid = uid;
//    }
//
//    public String getNombres() {
//        return nombres;
//    }
//
//    public void setNombres(String nombres) {
//        this.nombres = nombres;
//    }
//
//    public String getApellidos() {
//        return apellidos;
//    }
//
//    public void setApellidos(String apellidos) {
//        this.apellidos = apellidos;
//    }
//
//    public String getCorreo() {
//        return correo;
//    }
//
//    public void setCorreo(String correo) {
//        this.correo = correo;
//    }
//
//    public String getTelefono() {
//        return telefono;
//    }
//
//    public void setTelefono(String telefono) {
//        this.telefono = telefono;
//    }
//
//    public String getAnexo() {
//        return anexo;
//    }
//
//    public void setAnexo(String anexo) {
//        this.anexo = anexo;
//    }
//
//    public Integer getId_lugar_trabajo() {
//        return id_lugar_trabajo;
//    }
//
//    public void setId_lugar_trabajo(Integer id_lugar_trabajo) {
//        this.id_lugar_trabajo = id_lugar_trabajo;
//    }
//
//    public Timestamp getCreated_at() {
//        return created_at;
//    }
//
//    public void setCreated_at(Timestamp created_at) {
//        this.created_at = created_at;
//    }
//
//    public Timestamp getUpdated_at() {
//        return updated_at;
//    }
//
//    public void setUpdated_at(Timestamp updated_at) {
//        this.updated_at = updated_at;
//    }
//
//    public boolean isActivo() {
//        return activo;
//    }
//
//    public void setActivo(boolean activo) {
//        this.activo = activo;
//    }
//
//    public Cargo getCargo() {
//        return cargo;
//    }
//
//    public void setCargo(Cargo cargo) {
//        this.cargo = cargo;
//    }
//
//    public Set<PermisosUsuario> getPermisos() {
//        return permisos;
//    }
//
//    public void setPermisos(Set<PermisosUsuario> permisos) {
//        this.permisos = permisos;
//    }
//
//    public String getPassword(){
//        return password;
//    }
//
//    public void setPassword(String password){
//        this.password = password;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Usuario usuario = (Usuario) o;
//        return id.equals(usuario.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
