package edu.icet.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "developer_skill")
public class DeveloperSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne

    private DeveloperProfile developerProfile;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private String proficiencyLevel;
}
