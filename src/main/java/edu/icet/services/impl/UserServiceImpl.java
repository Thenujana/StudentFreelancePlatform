package edu.icet.services.impl;

import edu.icet.dto.LoginDto;
import edu.icet.dto.UserDto;
import edu.icet.entity.User;
import edu.icet.repository.UserRepository;
import edu.icet.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final ModelMapper mapper;

    @Override
    public void register(UserDto userDto) {

        User existingUser = repository.findByEmail(userDto.getEmail());

        if(existingUser != null){
            throw new RuntimeException("Email Already Exists");
        }

        repository.save(mapper.map(userDto, User.class));

    }

    @Override
    public UserDto login(LoginDto loginDto) {

        User user = repository.findByEmail(loginDto.getEmail());

        if(user == null){
            throw new RuntimeException("Email Not Found");
        }

        if(!user.getPassword().equals(loginDto.getPassword())){
            throw new RuntimeException("Incorrect Password");
        }

        return mapper.map(user, UserDto.class);

    }

    @Override
    public void updateUser(UserDto userDto) {

        repository.save(mapper.map(userDto,User.class));

    }

    @Override
    public void deleteUser(Long id) {

        repository.deleteById(id);

    }

    @Override
    public List<UserDto> getAll() {

        return repository.findAll()
                .stream()
                .map(user -> mapper.map(user,UserDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public UserDto getByEmail(String email) {

        User user = repository.findByEmail(email);

        if(user==null){
            throw new RuntimeException("User Not Found");
        }

        return mapper.map(user,UserDto.class);

    }
}