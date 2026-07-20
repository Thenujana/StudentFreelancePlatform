package edu.icet.services.impl;

import edu.icet.dto.DeveloperProfileDto;
import edu.icet.entity.DeveloperProfile;
import edu.icet.entity.User;
import edu.icet.repository.DeveloperProfileRepository;
import edu.icet.repository.UserRepository;
import edu.icet.services.DeveloperProfileService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DeveloperProfileServiceImpl implements DeveloperProfileService {

    private final DeveloperProfileRepository repository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public void addDeveloperProfile(DeveloperProfileDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        DeveloperProfile developerProfile = mapper.map(dto, DeveloperProfile.class);

        developerProfile.setUser(user);

        repository.save(developerProfile);

    }

    @Override
    public void updateDeveloperProfile(DeveloperProfileDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        DeveloperProfile developerProfile = mapper.map(dto, DeveloperProfile.class);

        developerProfile.setUser(user);

        repository.save(developerProfile);

    }

    @Override
    public DeveloperProfileDto getByUserId(Long userId) {

        DeveloperProfile developerProfile = repository.findByUserId(userId);

        if(developerProfile == null){
            throw new RuntimeException("Developer Profile Not Found");
        }

        DeveloperProfileDto dto = mapper.map(developerProfile, DeveloperProfileDto.class);

        dto.setUserId(developerProfile.getUser().getId());

        return dto;

    }
}