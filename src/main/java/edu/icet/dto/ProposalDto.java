package edu.icet.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ProposalDto {

    private Long id;

    private Long projectId;

    private Long developerProfileId;

    private String proposalText;

    private Double bidAmount;

    private Integer estimatedDays;

    private String status;

    private LocalDate appliedDate;

}