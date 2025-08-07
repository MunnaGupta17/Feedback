package com.getFeedback.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getFeedback.model.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{
	
	Optional<UserProfile> findByUsername(String username);
    boolean existsByUsername(String username);

}
