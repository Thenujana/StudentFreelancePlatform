package edu.icet.repository;

import edu.icet.dto.DeveloperProfileDto;
import edu.icet.entity.DeveloperProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperProfileRepository extends JpaRepository<DeveloperProfile,Long> {
    DeveloperProfile findByUserId(Long userId);

}
