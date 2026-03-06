package com.jins.db.Todoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jins.db.Todoapp.utils.Etat;
import com.jins.db.Todoapp.utils.Priorite;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "taches_todo")
@RequiredArgsConstructor
@Getter
@Setter
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String contenu;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

}
