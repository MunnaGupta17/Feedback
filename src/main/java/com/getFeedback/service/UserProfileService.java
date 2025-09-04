package com.getFeedback.service;

import com.getFeedback.model.UserProfile;
import com.getFeedback.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository repository;

    public UserProfile createProfile(UserProfile profile) {
        if (repository.existsByUsername(profile.getUsername())) {
            throw new RuntimeException("Username already taken");
        }
        return repository.save(profile);
    }

    public Optional<UserProfile> getByUsername(String username) {
        return repository.findByUsername(username);
    }
    
    public List<UserProfile> searchProfiles(String query) {
        return repository.search(query);
    }

    
}
