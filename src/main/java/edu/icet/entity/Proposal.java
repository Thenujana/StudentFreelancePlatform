package edu.icet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "proposal_table")

public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "Developer_profile_id")
    private DeveloperProfile developerProfile;

    @Column(length = 3000)
    private String proposalText;

    private Double bidAmount;

    private Integer estimatedDays;

    private String status;

    private LocalDate appliedDate;

}