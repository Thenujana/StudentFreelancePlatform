package edu.icet.services;

import edu.icet.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    void addProject(ProjectDto projectDto);

    void updateProject(ProjectDto projectDto);

    void deleteProject(Long id);

    List<ProjectDto> getAll();

    List<ProjectDto> getByClient(Long clientId);
}
