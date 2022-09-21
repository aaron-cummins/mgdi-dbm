package cl.cummins.mgdi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementCargo")
    public Long id;

    @Column(length = 250)
    public String nombre;

    @Column()
    public boolean activo;


}
