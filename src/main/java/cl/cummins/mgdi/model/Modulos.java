package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name="modulos")
public class Modulos {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementModulos")
        public Long id;

        @Column(length = 250)
        public String nombre;

        @Column(length = 250)
        public String controller;

        @OneToMany()
        @JoinColumn(name = "id_modulo")
        @JsonManagedReference
        @JsonIgnore
        public List<VistasGroup> grupos;

        @Column()
        public Timestamp created_at;
        @Column()
        public Timestamp updated_at;

    }
