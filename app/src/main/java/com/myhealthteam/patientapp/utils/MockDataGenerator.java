package com.myhealthteam.patientapp.utils;

import com.myhealthteam.patientapp.models.AllergyDto;
import com.myhealthteam.patientapp.models.VitalDto;
import com.myhealthteam.patientapp.models.VitalsSummaryDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockDataGenerator {
    public static List<AllergyDto> getAllergyMockData() {
        List<AllergyDto> mockData = new ArrayList<>();
        mockData.add(new AllergyDto(1L,"Penicillin", "Drug", "Severe", "Anaphylaxis", "Mar 12, 2022",1L));
        mockData.add(new AllergyDto(2L, "Pollen", "Environmental", "Moderate", "Sneezing", "Apr 02, 2023", 1L));
        return mockData;
    }

    public static VitalsSummaryDto getVitalsMockData() {
        Map<String, VitalDto> latestReadings =  new HashMap<>();
        // Blood Pressure
        latestReadings.put("Blood Pressure", VitalDto.builder()
                .id(6L)
                .reading("130/85 mmHg")
                .type("Blood Pressure")
                .measuredAt("2023-05-02T08:00:00")
                .status("Elevated")
                .patientId(1L)
                .build());

        // Sugar Level
        latestReadings.put("Sugar Level", VitalDto.builder()
                .id(5L)
                .reading("95 mg/dL")
                .type("Sugar Level")
                .measuredAt("2023-05-01T08:20:00")
                .status("Normal")
                .patientId(1L)
                .build());

        // Body Temperature
        latestReadings.put("Body Temperature", VitalDto.builder()
                .id(7L)
                .reading("99.1°F")
                .type("Body Temperature")
                .measuredAt("2023-05-02T08:05:00")
                .status("Fever")
                .patientId(1L)
                .build());

        // Blood Oxygen
        latestReadings.put("Blood Oxygen", VitalDto.builder()
                .id(4L)
                .reading("97%")
                .type("Blood Oxygen")
                .measuredAt("2023-05-01T08:15:00")
                .status("Normal")
                .patientId(1L)
                .build());

        // Pulse Rate
        latestReadings.put("Pulse Rate", VitalDto.builder()
                .id(3L)
                .reading("72 bpm")
                .type("Pulse Rate")
                .measuredAt("2023-05-01T08:10:00")
                .status("Normal")
                .patientId(1L)
                .build());

        return VitalsSummaryDto.builder()
                .latestReadings(latestReadings)
                .lastUpdated("2025-08-20T21:02:54.620776")
                .build();
    }
}
