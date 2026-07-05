package edu.icet.services;

import edu.icet.dto.ProposalDto;

import java.util.List;

public interface ProposalService {
    void submitProposal(ProposalDto proposalDto);

    void updateProposal(ProposalDto proposalDto);

    void deleteProposal(Long id);

    List<ProposalDto> getByProject(Long projectId);

    List<ProposalDto> getByDeveloper(Long developerId);
}
