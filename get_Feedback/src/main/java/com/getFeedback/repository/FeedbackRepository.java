package com.getFeedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getFeedback.model.Feedback;
import com.getFeedback.model.UserProfile;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
	
	List<Feedback> findByUserProfile(UserProfile userProfile);

}
