package edu.icet.controller;

import edu.icet.dto.SkillDto;
import edu.icet.services.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
@RequiredArgsConstructor
@CrossOrigin

public class SkillController {

    private final SkillService service;

    @PostMapping
    public ResponseEntity<String> addSkill(@RequestBody SkillDto dto){

        service.addSkill(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Skill Added Successfully");

    }

    @PutMapping
    public ResponseEntity<String> updateSkill(@RequestBody SkillDto dto){

        service.updateSkill(dto);

        return ResponseEntity.ok("Skill Updated Successfully");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSkill(@PathVariable Long id){

        service.deleteSkill(id);

        return ResponseEntity.ok("Skill Deleted Successfully");

    }

    @GetMapping
    public ResponseEntity<List<SkillDto>> getAll(){

        return ResponseEntity.ok(service.getAll());

    }

    @GetMapping("/search/{skillName}")
    public ResponseEntity<List<SkillDto>> searchSkill(
            @PathVariable String skillName){

        return ResponseEntity.ok(service.searchSkill(skillName));

    }

}