package cl.cummins.mgdi.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
@Data
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementCargo")
    public Long id;

    @Column(length = 250)
    public String nombre;
    @Column()
    public boolean activo;


}
