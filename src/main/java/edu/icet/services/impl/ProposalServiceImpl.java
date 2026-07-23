package edu.icet.services.impl;

import edu.icet.dto.ProposalDto;
import edu.icet.entity.DeveloperProfile;
import edu.icet.entity.Project;
import edu.icet.entity.Proposal;
import edu.icet.repository.DeveloperProfileRepository;
import edu.icet.repository.ProjectRepository;
import edu.icet.repository.ProposalRepository;
import edu.icet.services.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProposalServiceImpl implements ProposalService {

    private final ProposalRepository repository;
    private final ProjectRepository projectRepository;
    private final DeveloperProfileRepository developerRepository;

    @Override
    public void addProposal(ProposalDto dto) {

        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project Not Found"));

        DeveloperProfile developer = developerRepository.findById(dto.getDeveloperProfileId())
                .orElseThrow(() -> new RuntimeException("Developer Not Found"));

        Proposal proposal = new Proposal();

        proposal.setProject(project);
        proposal.setDeveloperProfile(developer);
        proposal.setProposalText(dto.getProposalText());
        proposal.setBidAmount(dto.getBidAmount());
        proposal.setEstimatedDays(dto.getEstimatedDays());
        proposal.setStatus("PENDING");
        proposal.setAppliedDate(LocalDate.now());

        repository.save(proposal);
    }

    @Override
    public void updateProposal(ProposalDto dto) {

        Proposal proposal = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Proposal Not Found"));

        proposal.setProposalText(dto.getProposalText());
        proposal.setBidAmount(dto.getBidAmount());
        proposal.setEstimatedDays(dto.getEstimatedDays());
        proposal.setStatus(dto.getStatus());

        repository.save(proposal);
    }

    @Override
    public void deleteProposal(Long id) {

        repository.deleteById(id);

    }

    @Override
    public List<ProposalDto> getAllProposals() {

        return repository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    @Override
    public ProposalDto searchProposal(Long id) {

        Proposal proposal = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proposal Not Found"));

        return convertToDto(proposal);

    }

    @Override
    public List<ProposalDto> getProposalsByProject(Long projectId) {

        return repository.findByProject_Id(projectId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<ProposalDto> getProposalsByDeveloper(Long developerProfileId) {

        return repository.findByDeveloperProfile_Id(developerProfileId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<ProposalDto> getProposalsByStatus(String status) {

        return repository.findByStatus(status)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    private ProposalDto convertToDto(Proposal proposal){

        ProposalDto dto = new ProposalDto();

        dto.setId(proposal.getId());
        dto.setProjectId(proposal.getProject().getId());
        dto.setDeveloperProfileId(proposal.getDeveloperProfile().getId());
        dto.setProposalText(proposal.getProposalText());
        dto.setBidAmount(proposal.getBidAmount());
        dto.setEstimatedDays(proposal.getEstimatedDays());
        dto.setStatus(proposal.getStatus());
        dto.setAppliedDate(proposal.getAppliedDate());

        return dto;
    }

}