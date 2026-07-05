package edu.icet.dto;

import edu.icet.entity.Project;
import edu.icet.entity.Skill;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectSkillDto {
    private Long id;

    private Project project;

    private Skill skill;
}
