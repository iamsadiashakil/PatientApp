package com.myhealthteam.patientapp.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VitalDto {
    private Long id;

    private String reading;

    private String type;

    private String measuredAt;

    private String status;

    private Long patientId;
}