package edu.icet.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ProjectSkillDto {

    private Long id;

    private Long projectId;

    private Long skillId;

}