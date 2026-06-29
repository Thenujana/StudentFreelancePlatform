package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MilestoneDto {
    private Long id;

    private Long projectId;

    private String title;

    private String description;

    private Double amount;

    private LocalDate dueDate;

    private String status;
}
