package edu.icet.controller;

import edu.icet.dto.ProjectDto;
import edu.icet.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
@CrossOrigin

public class ProjectController {

    private final ProjectService service;

    @PostMapping
    public ResponseEntity<String> addProject(@RequestBody ProjectDto dto){

        service.addProject(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Project Added Successfully");

    }

    @PutMapping
    public ResponseEntity<String> updateProject(@RequestBody ProjectDto dto){

        service.updateProject(dto);

        return ResponseEntity.ok("Project Updated Successfully");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id){

        service.deleteProject(id);

        return ResponseEntity.ok("Project Deleted Successfully");

    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects(){

        return ResponseEntity.ok(service.getAllProjects());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> searchProject(@PathVariable Long id){

        return ResponseEntity.ok(service.searchProject(id));

    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ProjectDto>> getProjectsByClient(@PathVariable Long clientId){

        return ResponseEntity.ok(service.getProjectsByClient(clientId));

    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ProjectDto>> getProjectsByStatus(@PathVariable String status){

        return ResponseEntity.ok(service.getProjectsByStatus(status));

    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<ProjectDto>> searchByTitle(@PathVariable String title){

        return ResponseEntity.ok(service.searchProjectsByTitle(title));

    }

}