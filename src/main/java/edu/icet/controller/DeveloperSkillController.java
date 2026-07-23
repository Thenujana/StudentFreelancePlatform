package edu.icet.controller;

import edu.icet.dto.DeveloperSkillDto;
import edu.icet.services.DeveloperSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developer-skill")
@RequiredArgsConstructor
@CrossOrigin

public class DeveloperSkillController {

    private final DeveloperSkillService service;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody DeveloperSkillDto dto){

        service.addDeveloperSkill(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Developer Skill Added Successfully");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody DeveloperSkillDto dto){

        service.updateDeveloperSkill(dto);

        return ResponseEntity.ok("Developer Skill Updated Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        service.deleteDeveloperSkill(id);

        return ResponseEntity.ok("Developer Skill Deleted Successfully");
    }

    @GetMapping("/{developerProfileId}")
    public ResponseEntity<List<DeveloperSkillDto>> getByDeveloper(
            @PathVariable Long developerProfileId){

        return ResponseEntity.ok(service.getByDeveloper(developerProfileId));
    }

}