package edu.icet.services;

import edu.icet.dto.ProposalDto;

import java.util.List;

public interface ProposalService {

    void addProposal(ProposalDto dto);

    void updateProposal(ProposalDto dto);

    void deleteProposal(Long id);

    List<ProposalDto> getAllProposals();

    ProposalDto searchProposal(Long id);

    List<ProposalDto> getProposalsByProject(Long projectId);

    List<ProposalDto> getProposalsByDeveloper(Long developerProfileId);

    List<ProposalDto> getProposalsByStatus(String status);

}