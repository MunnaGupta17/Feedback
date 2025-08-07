package com.getFeedback.controller;


import com.getFeedback.model.UserProfile;
import com.getFeedback.service.UserProfileService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class UserProfileController {

    @Autowired
    private UserProfileService service;

    @PostMapping
    public ResponseEntity<?> createProfile(@RequestBody UserProfile profile) {
        try {
            return ResponseEntity.ok(service.createProfile(profile));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getProfile(@PathVariable String username) {
        return service.getByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<UserProfile>> searchProfiles(@RequestParam String query) {
        return ResponseEntity.ok(service.searchProfiles(query));
    }

    
}
