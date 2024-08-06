package com.max.quizspring.service;

import com.max.quizspring.auth.ReviewRequest;
import com.max.quizspring.model.Review;
import com.max.quizspring.repo.ReviewRepository;
import com.max.quizspring.repo.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    public Review saveReview(ReviewRequest reviewRequest) {
        Review review = new Review();
        review.setComment(reviewRequest.getComment());
        review.setRating(reviewRequest.getRating());
        review.setProperty(propertyRepository.findById(reviewRequest.getPropertyId()).orElse(null));
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
