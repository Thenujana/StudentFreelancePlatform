package edu.icet.services;

import edu.icet.dto.DeveloperSkillDto;

import java.util.List;

public interface DeveloperSkillService {

    void addDeveloperSkill(DeveloperSkillDto dto);

    void updateDeveloperSkill(DeveloperSkillDto dto);

    void deleteDeveloperSkill(Long id);

    List<DeveloperSkillDto> getByDeveloper(Long developerProfileId);

}