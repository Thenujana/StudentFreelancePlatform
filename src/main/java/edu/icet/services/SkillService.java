package edu.icet.services;

import edu.icet.dto.SkillDto;

import java.util.List;

public interface SkillService {
    void addSkill(SkillDto skillDto);

    void updateSkill(SkillDto skillDto);

    void deleteSkill(Long id);

    List<SkillDto> getAll();
}
