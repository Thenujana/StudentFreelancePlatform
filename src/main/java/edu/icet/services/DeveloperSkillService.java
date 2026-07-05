package edu.icet.services;

import edu.icet.dto.DeveloperSkillDto;

import java.util.List;

public interface DeveloperSkillService {
    void addDeveloperSkill(DeveloperSkillDto developerSkillDto);

    void deleteDeveloperSkill(Long id);

    List<DeveloperSkillDto> getByDeveloper(Long developerId);
}
