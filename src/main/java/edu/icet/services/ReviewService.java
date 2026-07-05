package edu.icet.services;

import edu.icet.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    void addReview(ReviewDto reviewDto);

    List<ReviewDto> getByUser(Long userId);
}
