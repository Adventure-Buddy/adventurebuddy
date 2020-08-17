package com.codeup.adventurebuddy.models;

import javax.persistence.*;

@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private int rating;
    @Column(nullable = false)
    private String comment;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private long user_id;
    @Column(nullable = false)
    private long trail_id;
    @Column(nullable = false)
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "trail_num")
    private Trail trail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getTrail_id() {
        return trail_id;
    }

    public void setTrail_id(long trail_id) {
        this.trail_id = trail_id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Review(long id, int rating, String comment, String image, long user_id, long trail_id, String createdAt) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.image = image;
        this.user_id = user_id;
        this.trail_id = trail_id;
        this.createdAt = createdAt;
    }

    public Review() {
    }
}
