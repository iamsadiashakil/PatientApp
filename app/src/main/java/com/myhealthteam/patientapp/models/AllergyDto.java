package com.myhealthteam.patientapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AllergyDto {
    private Long id;

    private String name;

    private String type;

    private String severity;

    private String reaction;

    private String notedOn;

    private Long patientId;
}