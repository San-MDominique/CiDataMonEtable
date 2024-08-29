package com.example.monwebetable.services.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class TeacherDTO extends PersonneDTO {

    @NotNull
    @JsonProperty("isVacant")

    private boolean vacant;

    private String matiereEnseigne;

    private String prochainCours;

    private String sujetProchaineReunion;


}
