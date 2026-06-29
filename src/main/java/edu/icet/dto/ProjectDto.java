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

    private Long clientId;

    private String title;

    private String description;

    private Double budget;

    private LocalDate deadline;

    private String status;
}
