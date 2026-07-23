package edu.icet.repository;

import edu.icet.entity.ProjectSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectSkillRepository extends JpaRepository<ProjectSkill, Long> {

    List<ProjectSkill> findByProject_Id(Long projectId);

}