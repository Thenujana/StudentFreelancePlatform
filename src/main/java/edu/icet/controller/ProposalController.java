package edu.icet.controller;

import edu.icet.dto.ProposalDto;
import edu.icet.services.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proposal")
@RequiredArgsConstructor
@CrossOrigin
public class ProposalController {

    private final ProposalService service;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody ProposalDto dto){

        service.addProposal(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Proposal Submitted Successfully");

    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ProposalDto dto){

        service.updateProposal(dto);

        return ResponseEntity.ok("Proposal Updated Successfully");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        service.deleteProposal(id);

        return ResponseEntity.ok("Proposal Deleted Successfully");

    }

    @GetMapping
    public ResponseEntity<List<ProposalDto>> getAll(){

        return ResponseEntity.ok(service.getAllProposals());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProposalDto> getById(@PathVariable Long id){

        return ResponseEntity.ok(service.searchProposal(id));

    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<ProposalDto>> getByProject(@PathVariable Long projectId){

        return ResponseEntity.ok(service.getProposalsByProject(projectId));

    }

    @GetMapping("/developer/{developerId}")
    public ResponseEntity<List<ProposalDto>> getByDeveloper(@PathVariable Long developerId){

        return ResponseEntity.ok(service.getProposalsByDeveloper(developerId));

    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ProposalDto>> getByStatus(@PathVariable String status){

        return ResponseEntity.ok(service.getProposalsByStatus(status));

    }

}