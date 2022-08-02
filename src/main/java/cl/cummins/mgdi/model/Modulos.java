package cl.cummins.mgdi.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="modulos")
public class Modulos {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementModulos")
        @GenericGenerator(name = "incrementModulo", strategy = "increment")
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
