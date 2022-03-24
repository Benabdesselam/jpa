package com.example.oulouda.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Patient {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
        private Long id;
        @Column(name = "nom",length = 50)
        private String nom;
        @Temporal(TemporalType.DATE)
        private Date dateNaissance;
        private boolean malade;
        private int score;


}
