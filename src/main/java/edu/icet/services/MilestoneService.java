package edu.icet.services;

import edu.icet.dto.MilestoneDto;

import java.util.List;

public interface MilestoneService {
    void addMilestone(MilestoneDto milestoneDto);

    void updateMilestone(MilestoneDto milestoneDto);

    List<MilestoneDto> getByProject(Long projectId);
}
