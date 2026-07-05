package edu.icet.services;

import edu.icet.dto.DeveloperProfileDto;

public interface DeveloperProfileService {
    void addDeveloperProfile(DeveloperProfileDto developerProfileDto);

    void updateDeveloperProfile(DeveloperProfileDto developerProfileDto);

    DeveloperProfileDto getByUserId(Long userId);
}
