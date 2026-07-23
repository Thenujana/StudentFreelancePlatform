package edu.icet.services.impl;

import edu.icet.dto.ProjectDto;
import edu.icet.entity.ClientProfile;
import edu.icet.entity.Project;
import edu.icet.repository.ClientProfileRepository;
import edu.icet.repository.ProjectRepository;
import edu.icet.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;
    private final ClientProfileRepository clientRepository;
    private final ModelMapper mapper;

    @Override
    public void addProject(ProjectDto dto) {

        ClientProfile client = clientRepository.findById(dto.getClientProfileId())
                .orElseThrow(() -> new RuntimeException("Client Not Found"));

        Project project = new Project();

        project.setClientProfile(client);
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setBudget(dto.getBudget());
        project.setDeadline(dto.getDeadline());
        project.setExperienceLevel(dto.getExperienceLevel());
        project.setProjectType(dto.getProjectType());
        project.setStatus("OPEN");
        project.setCreatedDate(LocalDate.now());

        repository.save(project);

    }

    @Override
    public void updateProject(ProjectDto dto) {

        ClientProfile client = clientRepository.findById(dto.getClientProfileId())
                .orElseThrow(() -> new RuntimeException("Client Not Found"));

        Project project = new Project();

        project.setId(dto.getId());
        project.setClientProfile(client);
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setBudget(dto.getBudget());
        project.setDeadline(dto.getDeadline());
        project.setExperienceLevel(dto.getExperienceLevel());
        project.setProjectType(dto.getProjectType());
        project.setStatus(dto.getStatus());
        project.setCreatedDate(dto.getCreatedDate());

        repository.save(project);

    }

    @Override
    public void deleteProject(Long id) {

        repository.deleteById(id);

    }

    @Override
    public List<ProjectDto> getAllProjects() {

        return repository.findAll()
                .stream()
                .map(project -> {

                    ProjectDto dto = new ProjectDto();

                    dto.setId(project.getId());
                    dto.setClientProfileId(project.getClientProfile().getId());
                    dto.setTitle(project.getTitle());
                    dto.setDescription(project.getDescription());
                    dto.setBudget(project.getBudget());
                    dto.setDeadline(project.getDeadline());
                    dto.setExperienceLevel(project.getExperienceLevel());
                    dto.setProjectType(project.getProjectType());
                    dto.setStatus(project.getStatus());
                    dto.setCreatedDate(project.getCreatedDate());

                    return dto;

                }).collect(Collectors.toList());

    }

    @Override
    public ProjectDto searchProject(Long id) {

        Project project = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project Not Found"));

        ProjectDto dto = new ProjectDto();

        dto.setId(project.getId());
        dto.setClientProfileId(project.getClientProfile().getId());
        dto.setTitle(project.getTitle());
        dto.setDescription(project.getDescription());
        dto.setBudget(project.getBudget());
        dto.setDeadline(project.getDeadline());
        dto.setExperienceLevel(project.getExperienceLevel());
        dto.setProjectType(project.getProjectType());
        dto.setStatus(project.getStatus());
        dto.setCreatedDate(project.getCreatedDate());

        return dto;

    }

    @Override
    public List<ProjectDto> getProjectsByClient(Long clientProfileId) {

        return repository.findByClientProfile_Id(clientProfileId)
                .stream()
                .map(project -> {

                    ProjectDto dto = new ProjectDto();

                    dto.setId(project.getId());
                    dto.setClientProfileId(project.getClientProfile().getId());
                    dto.setTitle(project.getTitle());
                    dto.setDescription(project.getDescription());
                    dto.setBudget(project.getBudget());
                    dto.setDeadline(project.getDeadline());
                    dto.setExperienceLevel(project.getExperienceLevel());
                    dto.setProjectType(project.getProjectType());
                    dto.setStatus(project.getStatus());
                    dto.setCreatedDate(project.getCreatedDate());

                    return dto;

                }).collect(Collectors.toList());

    }

    @Override
    public List<ProjectDto> getProjectsByStatus(String status) {

        return repository.findByStatus(status)
                .stream()
                .map(project -> {

                    ProjectDto dto = new ProjectDto();

                    dto.setId(project.getId());
                    dto.setClientProfileId(project.getClientProfile().getId());
                    dto.setTitle(project.getTitle());
                    dto.setDescription(project.getDescription());
                    dto.setBudget(project.getBudget());
                    dto.setDeadline(project.getDeadline());
                    dto.setExperienceLevel(project.getExperienceLevel());
                    dto.setProjectType(project.getProjectType());
                    dto.setStatus(project.getStatus());
                    dto.setCreatedDate(project.getCreatedDate());

                    return dto;

                }).collect(Collectors.toList());

    }

    @Override
    public List<ProjectDto> searchProjectsByTitle(String title) {

        return repository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(project -> {

                    ProjectDto dto = new ProjectDto();

                    dto.setId(project.getId());
                    dto.setClientProfileId(project.getClientProfile().getId());
                    dto.setTitle(project.getTitle());
                    dto.setDescription(project.getDescription());
                    dto.setBudget(project.getBudget());
                    dto.setDeadline(project.getDeadline());
                    dto.setExperienceLevel(project.getExperienceLevel());
                    dto.setProjectType(project.getProjectType());
                    dto.setStatus(project.getStatus());
                    dto.setCreatedDate(project.getCreatedDate());

                    return dto;

                }).collect(Collectors.toList());

    }

}