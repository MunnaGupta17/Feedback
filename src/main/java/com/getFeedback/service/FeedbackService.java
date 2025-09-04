package com.getFeedback.service;

import com.getFeedback.model.Feedback;
import com.getFeedback.model.UserProfile;
import com.getFeedback.repository.FeedbackRepository;
import com.getFeedback.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public Feedback submitFeedback(String username, Feedback feedback) {
        UserProfile profile = userProfileRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Default anonymous values..
        if (feedback.getAuthorName() == null || feedback.getAuthorName().isBlank()) {
            feedback.setAuthorName("Anonymous");
        }
        if (feedback.getAuthorEmail() != null && feedback.getAuthorEmail().isBlank()) {
            feedback.setAuthorEmail(null); // optional email
        }

        feedback.setUserProfile(profile);
        feedback.setCreatedAt(java.time.LocalDateTime.now());
        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getFeedbackForUser(String username) {
        UserProfile profile = userProfileRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return feedbackRepository.findByUserProfile(profile);
    }
}
