package edu.icet.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "skill")
public class Skill {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;
}
