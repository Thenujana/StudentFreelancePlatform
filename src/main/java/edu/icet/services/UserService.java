package edu.icet.services;

import edu.icet.dto.LoginDto;
import edu.icet.dto.UserDto;

import java.util.List;

public interface UserService {
    void register(UserDto userDto);

    UserDto login(LoginDto loginDto);

    void updateUser(UserDto userDto);

    void deleteUser(Long id);

    List<UserDto> getAll();

    UserDto getByEmail(String email);
}
