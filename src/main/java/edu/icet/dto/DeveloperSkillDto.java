package edu.icet.dto;

import edu.icet.entity.DeveloperProfile;
import edu.icet.entity.Skill;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class DeveloperSkillDto {

    private Long id;
    private Long developerProfileId;
    private Long skillId;
    private String proficiencyLevel;
}
