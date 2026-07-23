package edu.icet.services;

import edu.icet.dto.ProjectSkillDto;

import java.util.List;

public interface ProjectSkillService {

    void addProjectSkill(ProjectSkillDto dto);

    void updateProjectSkill(ProjectSkillDto dto);

    void deleteProjectSkill(Long id);

    List<ProjectSkillDto> getProjectSkills(Long projectId);

}