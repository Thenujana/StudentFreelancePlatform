package edu.icet.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeveloperProfileDto {
    private Long id;

    private Long userId;

    private String university;

    private String degreeProgram;

    private Integer graduationYear;

    private String bio;

    private String githubUrl;

    private String linkedinUrl;
}
