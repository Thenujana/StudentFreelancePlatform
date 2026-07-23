package edu.icet.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ProjectDto {

    private Long id;

    private Long clientProfileId;

    private String title;

    private String description;

    private Double budget;

    private LocalDate deadline;

    private String experienceLevel;

    private String projectType;

    private String status;

    private LocalDate createdDate;

}