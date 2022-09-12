package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementUsuario")
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

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private Set<PermisosUsuario> permisos;

    @Column()
    public Timestamp created_at;
    @Column()
    public Timestamp updated_at;
    @Column()
    public boolean activo;


}
