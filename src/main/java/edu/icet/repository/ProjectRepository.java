package edu.icet.repository;

import edu.icet.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByStatus(String status);

    List<Project> findByClientProfile_Id(Long clientProfileId);

    List<Project> findByTitleContainingIgnoreCase(String title);

}