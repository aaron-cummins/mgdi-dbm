package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="vistas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vistas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementVistas")
    public Long id;

    @Column(length = 250)
    public String nombre;

    @Column(length = 250)
    public String accion;

    @Column(length = 250)
    public String controller;

    /*@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    public VistasGroup grupo;*/

    public Long id_grupo;

    @Column()
    public Timestamp created_at;
    @Column()
    public Timestamp updated_at;

}
