package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="lugar_trabajo")
@Data
public class LugarTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementLugarTrabajo")
    public Long id;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(length = 50)
    private String abreviacion;

    private Double longitud;

    private Double latitud;

    private Double altura;

    private String direccion;

    private String telefono;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Zona zona;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoLugarTrabajo tipoLugarTrabajo;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Comuna comuna;

    @OneToMany(mappedBy = "lugarTrabajo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Flotas> flotases = new LinkedHashSet<>();

    public Set<Flotas> getFlotases() {
        return flotases;
    }

    public void setFlotases(Set<Flotas> flotases) {
        this.flotases = flotases;
    }

//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Usuario usuario;


}
