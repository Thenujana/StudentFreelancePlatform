package edu.icet.controller;

import edu.icet.dto.ProjectSkillDto;
import edu.icet.services.ProjectSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-skill")
@RequiredArgsConstructor
@CrossOrigin

public class ProjectSkillController {

    private final ProjectSkillService service;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody ProjectSkillDto dto){

        service.addProjectSkill(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Project Skill Added Successfully");

    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ProjectSkillDto dto){

        service.updateProjectSkill(dto);

        return ResponseEntity.ok("Project Skill Updated Successfully");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        service.deleteProjectSkill(id);

        return ResponseEntity.ok("Project Skill Deleted Successfully");

    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<ProjectSkillDto>> getProjectSkills(@PathVariable Long projectId){

        return ResponseEntity.ok(service.getProjectSkills(projectId));

    }

}