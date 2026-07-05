package edu.icet.services;

import edu.icet.dto.ClientProfileDto;

public interface ClientProfileService {
    void addClientProfile(ClientProfileDto clientProfileDto);

    void updateClientProfile(ClientProfileDto clientProfileDto);

    ClientProfileDto getByUserId(Long userId);
}
