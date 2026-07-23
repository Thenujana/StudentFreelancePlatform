package edu.icet.repository;

import edu.icet.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {

    List<Proposal> findByProject_Id(Long projectId);

    List<Proposal> findByDeveloperProfile_Id(Long developerProfileId);

    List<Proposal> findByStatus(String status);

}