package edu.icet.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long developerId;

    private String projectTitle;

    private String description;

    private String githubLink;

    private String projectLink;

    private String imageUrl;
}
