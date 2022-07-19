package cl.cummins.mgdi.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="modulos")
public class Modulos {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;

        @Column(length = 250)
        public String nombre;

        @Column(length = 250)
        public String controller;

        @Column()
        public Timestamp created_at;
        @Column()
        public Timestamp updated_at;

    }
