package com.getFeedback.controller;

import com.getFeedback.model.Feedback;
import com.getFeedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/{username}")
    public ResponseEntity<?> submitFeedback(@PathVariable String username, @RequestBody Feedback feedback) {
        try {
            return ResponseEntity.ok(feedbackService.submitFeedback(username, feedback));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Feedback>> getFeedback(@PathVariable String username) {
        return ResponseEntity.ok(feedbackService.getFeedbackForUser(username));
    }
}
