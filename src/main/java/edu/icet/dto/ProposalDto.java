package edu.icet.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProposalDto {
    private Long id;

    private Long projectId;

    private Long developerId;

    private String proposalDescription;

    private Double Amount;

    private Integer estimatedDays;

    private String status;
}
