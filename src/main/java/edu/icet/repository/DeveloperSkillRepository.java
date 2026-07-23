package edu.icet.repository;

import edu.icet.entity.DeveloperSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeveloperSkillRepository extends JpaRepository<DeveloperSkill, Long> {

    List<DeveloperSkill> findByDeveloperProfile_Id(Long developerProfileId);

}