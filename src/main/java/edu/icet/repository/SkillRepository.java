package edu.icet.repository;

import edu.icet.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill,Long> {

    List<Skill> findBySkillNameContainingIgnoreCase(String skillName);

}