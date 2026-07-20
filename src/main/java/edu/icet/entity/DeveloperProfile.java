package edu.icet.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "Developer_profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeveloperProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;

    private String university;

    private String degreeProgram;

    private Integer graduationYear;

    private String bio;

    private String githubUrl;

    private String linkedinUrl;
}
