package edu.icet.repository;

import edu.icet.entity.ClientProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientProfileRepository extends JpaRepository<ClientProfile,Long> {
    ClientProfile findByUser_Id(Long userId);
}
