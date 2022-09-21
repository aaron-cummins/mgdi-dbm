package cl.cummins.mgdi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="modulos")
@Data
public class Modulos {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "incrementModulos")
        public Long id;

        @Column(length = 250)
        public String nombre;

        @Column(length = 250)
        public String controller;

        public String icono;

//        @OneToMany()
//        @JoinColumn(name = "id_modulo",insertable = false, updatable = false)
//        @JsonIgnore
//        @JsonManagedReference
//        private List<VistasGroup> grupos;

        @Column()
        public Timestamp created_at;
        @Column()
        public Timestamp updated_at;

    }
