package edu.icet.services;

import edu.icet.dto.ProjectDto;

import java.util.List;

public interface ProjectService {

    void addProject(ProjectDto dto);

    void updateProject(ProjectDto dto);

    void deleteProject(Long id);

    List<ProjectDto> getAllProjects();

    ProjectDto searchProject(Long id);

    List<ProjectDto> getProjectsByClient(Long clientProfileId);

    List<ProjectDto> getProjectsByStatus(String status);

    List<ProjectDto> searchProjectsByTitle(String title);

}