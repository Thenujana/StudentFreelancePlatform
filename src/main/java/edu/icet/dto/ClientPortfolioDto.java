package edu.icet.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientPortfolioDto {
    private Long id;

    private Long userId;

    private String companyName;

    private String companyDescription;

    private String websiteUrl;
}
