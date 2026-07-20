package edu.icet.services.impl;

import edu.icet.dto.SkillDto;
import edu.icet.entity.Skill;
import edu.icet.repository.SkillRepository;
import edu.icet.services.SkillService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class SkillServiceImpl implements SkillService {

    private final SkillRepository repository;
    private final ModelMapper mapper;

    @Override
    public void addSkill(SkillDto skillDto) {

        repository.save(mapper.map(skillDto, Skill.class));

    }

    @Override
    public void updateSkill(SkillDto skillDto) {

        repository.save(mapper.map(skillDto, Skill.class));

    }

    @Override
    public void deleteSkill(Long id) {

        repository.deleteById(id);

    }

    @Override
    public List<SkillDto> getAll() {

        return repository.findAll()
                .stream()
                .map(skill -> mapper.map(skill, SkillDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<SkillDto> searchSkill(String skillName) {

        return repository.findBySkillNameContainingIgnoreCase(skillName)
                .stream()
                .map(skill -> mapper.map(skill, SkillDto.class))
                .collect(Collectors.toList());

    }
}