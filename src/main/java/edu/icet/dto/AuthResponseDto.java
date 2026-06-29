package edu.icet.dto;

import jdk.jfr.Name;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponseDto {
    private Long userId;
    private String fullName;
    private String role;
    private String token;
    private String type="Bearer";
}
