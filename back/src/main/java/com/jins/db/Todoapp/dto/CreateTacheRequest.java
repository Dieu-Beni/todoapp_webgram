package com.jins.db.Todoapp.dto;

import com.jins.db.Todoapp.utils.Etat;
import com.jins.db.Todoapp.utils.Priorite;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;

@Getter
public class CreateTacheRequest {
    @NotBlank(message = "Le titre est obligatoire")
    private String titre;
    @NotBlank(message = "Le contenu est obligatoire")
    private String contenu;
    @NotNull(message = "La date est obligatoire")
    private Date date;
    @NotNull(message = "L'etat es obligatoire")
    private Etat etat;
    @NotNull(message = "La priorite est obligatoire")
    private Priorite priorite;

}
