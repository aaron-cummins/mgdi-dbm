package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementRegion")
    public Long id;

    @NotBlank(message = "El Numero es obligatorio")
    @Column(length = 10)
    public String numero;

    @NotBlank(message = "El nombre es obligatorio") @Size(min = 3, max = 250, message = "El nombre debe ser un valor entre 3 y 250 caracteres")
    @Column(length = 250)
    public String nombre;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)//mappedBy = "id")
    @JoinColumn(name = "region_id")
    @JsonManagedReference
    @JsonIgnore
    private List<Comuna> comunas;

    public boolean activo;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNumero() {
//        return numero;
//    }
//
//    public void setNumero(String numero) {
//        this.numero = numero;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public boolean isActivo() {
//        return activo;
//    }
//
//    public void setActivo(boolean activo) {
//        this.activo = activo;
//    }
}
