package edu.icet.services.impl;

import edu.icet.dto.DeveloperSkillDto;
import edu.icet.entity.DeveloperProfile;
import edu.icet.entity.DeveloperSkill;
import edu.icet.entity.Skill;
import edu.icet.repository.DeveloperProfileRepository;
import edu.icet.repository.DeveloperSkillRepository;
import edu.icet.repository.SkillRepository;
import edu.icet.services.DeveloperSkillService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class DeveloperSkillServiceImpl implements DeveloperSkillService {

    private final DeveloperSkillRepository repository;
    private final DeveloperProfileRepository developerRepository;
    private final SkillRepository skillRepository;
    private final ModelMapper mapper;

    @Override
    public void addDeveloperSkill(DeveloperSkillDto dto) {

        try {

            System.out.println("DTO : " + dto);

            DeveloperProfile developer = developerRepository.findById(dto.getDeveloperProfileId())
                    .orElseThrow(() -> new RuntimeException("Developer Not Found"));

            System.out.println("Developer : " + developer);

            Skill skill = skillRepository.findById(dto.getSkillId())
                    .orElseThrow(() -> new RuntimeException("Skill Not Found"));

            System.out.println("Skill : " + skill);

            DeveloperSkill developerSkill = new DeveloperSkill();

            developerSkill.setDeveloperProfile(developer);
            developerSkill.setSkill(skill);
            developerSkill.setProficiencyLevel(dto.getProficiencyLevel());

            repository.save(developerSkill);

            System.out.println("Saved Successfully");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    @Override
    public void updateDeveloperSkill(DeveloperSkillDto dto) {

        DeveloperProfile developer = developerRepository.findById(dto.getDeveloperProfileId())
                .orElseThrow(() -> new RuntimeException("Developer Not Found"));

        Skill skill = skillRepository.findById(dto.getSkillId())
                .orElseThrow(() -> new RuntimeException("Skill Not Found"));

        DeveloperSkill developerSkill = new DeveloperSkill();

        developerSkill.setId(dto.getId());
        developerSkill.setDeveloperProfile(developer);
        developerSkill.setSkill(skill);
        developerSkill.setProficiencyLevel(dto.getProficiencyLevel());

        repository.save(developerSkill);

    }

    @Override
    public void deleteDeveloperSkill(Long id) {

        repository.deleteById(id);

    }

    @Override
    public List<DeveloperSkillDto> getByDeveloper(Long developerProfileId) {

        return repository.findByDeveloperProfile_Id(developerProfileId)
                .stream()
                .map(skill -> {
                    DeveloperSkillDto dto = new DeveloperSkillDto();

                    dto.setId(skill.getId());
                    dto.setDeveloperProfileId(skill.getDeveloperProfile().getId());
                    dto.setSkillId(skill.getSkill().getId());
                    dto.setProficiencyLevel(skill.getProficiencyLevel());

                    return dto;
                })
                .collect(Collectors.toList());

    }
}