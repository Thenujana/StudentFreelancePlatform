package edu.icet.services;

import edu.icet.dto.ProjectSkillDto;

import java.util.List;

public interface ProjectSkillService {

    void addProjectSkill(ProjectSkillDto projectSkillDto);

    void deleteProjectSkill(Long id);

    List<ProjectSkillDto> getByProject(Long projectId);
}
