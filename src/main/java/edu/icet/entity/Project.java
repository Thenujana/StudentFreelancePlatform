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
@Table(name = "project_table")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne

    private ClientProfile clientProfile;

    private String title;

    @Column(length = 3000)
    private String description;

    private Double budget;

    private LocalDate deadline;

    private String experienceLevel;

    private String projectType;

    private String status;

    private LocalDate createdDate;

}