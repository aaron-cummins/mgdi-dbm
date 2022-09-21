package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="equipo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementEquipo")
    public Long id;

    private String nombre;

    public boolean activo;

    @Column(name = "aplicacion_oem_id")
    private Long aplicacionOemId;

    @Column(name = "oem_id")
    private Long oemId;


}
