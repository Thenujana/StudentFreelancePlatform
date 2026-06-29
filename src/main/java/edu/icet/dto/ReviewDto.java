package edu.icet.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ReviewDto {
    private Long id;

    private Long projectId;

    private Long reviewerId;

    private Long revieweeId;

    private Integer rating;

    private String comment;
}
