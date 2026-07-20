package edu.icet.controller;

import edu.icet.dto.DeveloperProfileDto;
import edu.icet.services.DeveloperProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/developer-profile")
@RequiredArgsConstructor
@CrossOrigin

public class DeveloperProfileController {

    private final DeveloperProfileService service;

    @PostMapping
    public ResponseEntity<String> addDeveloperProfile(
            @RequestBody DeveloperProfileDto dto){

        service.addDeveloperProfile(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Developer Profile Created Successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateDeveloperProfile(
            @RequestBody DeveloperProfileDto dto){

        service.updateDeveloperProfile(dto);

        return ResponseEntity.ok("Developer Profile Updated Successfully");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<DeveloperProfileDto> getDeveloperProfile(
            @PathVariable Long userId){

        return ResponseEntity.ok(service.getByUserId(userId));
    }

}