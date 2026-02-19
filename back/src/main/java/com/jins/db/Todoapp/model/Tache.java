package com.jins.db.Todoapp.model;

import com.jins.db.Todoapp.utils.Etat;
import com.jins.db.Todoapp.utils.Priorite;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "taches")
@RequiredArgsConstructor
@Getter
@Setter
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String contenu;
    private Date date;
    private Time heure;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    @ManyToOne
    private User user;

}
