package edu.icet.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientProfileDto {
    private Long id;

    private Long userId;

    private String companyName;

    private String companyDescription;

    private String websiteUrl;

    private String country;
}
