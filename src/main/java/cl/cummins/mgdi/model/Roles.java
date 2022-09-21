package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementRoles")
    public Long id;

    @Column(length = 250)
    public String nombre;

    //@OneToMany(mappedBy = "rol", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
//    @OneToMany()
//    @JoinColumn(name = "id_rol")
//    @JsonManagedReference
//    @JsonIgnore
//    public List<PermisosGlobales> permisosGlobales;

    @Column()
    public Timestamp created_at;
    @Column()
    public Timestamp updated_at;


}
