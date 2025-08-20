package com.myhealthteam.patientapp.models;

import lombok.Data;

@Data
public class AllergyDto {
    private Long id;

    private String name;

    private String type;

    private String severity;

    private String reaction;

    private String notedOn;

    private Long patientId;
}