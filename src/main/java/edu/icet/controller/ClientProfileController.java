package edu.icet.controller;

import edu.icet.dto.ClientProfileDto;
import edu.icet.services.ClientProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client-profile")
@RequiredArgsConstructor
@CrossOrigin

public class ClientProfileController {

    private final ClientProfileService service;

    @PostMapping
    public ResponseEntity<String> addClientProfile(
            @RequestBody ClientProfileDto dto) {

        service.addClientProfile(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Client Profile Created Successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateClientProfile(
            @RequestBody ClientProfileDto dto) {

        service.updateClientProfile(dto);

        return ResponseEntity.ok("Client Profile Updated Successfully");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ClientProfileDto> getByUserId(
            @PathVariable Long userId) {

        return ResponseEntity.ok(service.getByUserId(userId));
    }
}