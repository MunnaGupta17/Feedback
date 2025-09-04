package com.getFeedback.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.getFeedback.model.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{
	
	Optional<UserProfile> findByUsername(String username);
    boolean existsByUsername(String username);
    
    @Query("SELECT u FROM UserProfile u WHERE " +
            "LOWER(u.username) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(u.name) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(u.category) LIKE LOWER(CONCAT('%', :query, '%'))")
     List<UserProfile> search(@Param("query") String query);

}
