package edu.icet.services.impl;

import edu.icet.dto.ProjectSkillDto;
import edu.icet.entity.Project;
import edu.icet.entity.ProjectSkill;
import edu.icet.entity.Skill;
import edu.icet.repository.ProjectRepository;
import edu.icet.repository.ProjectSkillRepository;
import edu.icet.repository.SkillRepository;
import edu.icet.services.ProjectSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProjectSkillServiceImpl implements ProjectSkillService {

    private final ProjectSkillRepository repository;
    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;

    @Override
    public void addProjectSkill(ProjectSkillDto dto) {

        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project Not Found"));

        Skill skill = skillRepository.findById(dto.getSkillId())
                .orElseThrow(() -> new RuntimeException("Skill Not Found"));

        ProjectSkill projectSkill = new ProjectSkill();

        projectSkill.setProject(project);
        projectSkill.setSkill(skill);

        repository.save(projectSkill);

    }

    @Override
    public void updateProjectSkill(ProjectSkillDto dto) {

        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project Not Found"));

        Skill skill = skillRepository.findById(dto.getSkillId())
                .orElseThrow(() -> new RuntimeException("Skill Not Found"));

        ProjectSkill projectSkill = new ProjectSkill();

        projectSkill.setId(dto.getId());
        projectSkill.setProject(project);
        projectSkill.setSkill(skill);

        repository.save(projectSkill);

    }

    @Override
    public void deleteProjectSkill(Long id) {

        repository.deleteById(id);

    }

    @Override
    public List<ProjectSkillDto> getProjectSkills(Long projectId) {

        return repository.findByProject_Id(projectId)
                .stream()
                .map(projectSkill -> {

                    ProjectSkillDto dto = new ProjectSkillDto();

                    dto.setId(projectSkill.getId());
                    dto.setProjectId(projectSkill.getProject().getId());
                    dto.setSkillId(projectSkill.getSkill().getId());

                    return dto;

                }).collect(Collectors.toList());

    }
}