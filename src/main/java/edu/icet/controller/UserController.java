package edu.icet.controller;

import edu.icet.dto.LoginDto;
import edu.icet.dto.UserDto;
import edu.icet.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin

public class UserController {

    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto dto) {

        service.register(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User Registered Successfully");

    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginDto dto) {

        UserDto user = service.login(dto);

        return ResponseEntity.ok(user);

    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {

        return ResponseEntity.ok(service.getAll());

    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody UserDto dto) {

        service.updateUser(dto);

        return ResponseEntity.ok("User Updated Successfully");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        service.deleteUser(id);

        return ResponseEntity.ok("User Deleted Successfully");

    }

}