package edu.icet.services.impl;

import edu.icet.dto.ClientProfileDto;
import edu.icet.entity.ClientProfile;
import edu.icet.entity.User;
import edu.icet.repository.ClientProfileRepository;
import edu.icet.repository.UserRepository;
import edu.icet.services.ClientProfileService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientProfileServiceImpl implements ClientProfileService {

    private final ClientProfileRepository repository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public void addClientProfile(ClientProfileDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        ClientProfile profile = mapper.map(dto, ClientProfile.class);
        profile.setUser(user);

        repository.save(profile);
    }

    @Override
    public void updateClientProfile(ClientProfileDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        ClientProfile profile = mapper.map(dto, ClientProfile.class);
        profile.setUser(user);

        repository.save(profile);
    }

    @Override
    public ClientProfileDto getByUserId(Long userId) {

        ClientProfile profile = repository.findByUser_Id(userId);

        if (profile == null) {
            throw new RuntimeException("Client Profile Not Found");
        }

        ClientProfileDto dto = mapper.map(profile, ClientProfileDto.class);
        dto.setUserId(profile.getUser().getId());

        return dto;
    }
}