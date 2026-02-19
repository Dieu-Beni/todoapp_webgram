package com.jins.db.Todoapp.dto;

import com.jins.db.Todoapp.utils.Etat;
import com.jins.db.Todoapp.utils.Priorite;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

@Getter
public class CreateTacheRequest {
    @NotBlank(message = "Le titre est obligatoire")
    private String titre;
    @NotBlank(message = "Le contenu est obligatoire")
    private String contenu;
    @NotBlank(message = "La date est obligatoire")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
    @NotBlank(message = "L'heure est obligatoire")
    private Time heure;
    @NotBlank(message = "L'etat es obligatoire")
    private Etat etat;
    @NotBlank(message = "La priorite est ob;ligatoire")
    private Priorite priorite;

}
