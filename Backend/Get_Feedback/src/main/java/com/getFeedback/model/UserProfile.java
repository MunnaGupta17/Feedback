package com.getFeedback.model;

import jakarta.persistence.*;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username; // used in URL like /john123

    private String name;
    private String bio;
    private String category; // e.g. school, restaurant, influencer

    // Constructors, getters, setters
    public UserProfile() {}

    public UserProfile(String username, String name, String bio, String category) {
        this.username = username;
        this.name = name;
        this.bio = bio;
        this.category = category;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
    
    

    // Getters and Setters
    // (use Lombok later if you like)
}
