package edu.icet.dto;

import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PortfolioDto {
    private Long id;

    private Long developerId;

    private String projectTitle;

    private String description;

    private String githubLink;

    private String projectLink;

    private String imageUrl;
}
