package com.codeup.adventurebuddy.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "User_Buddy")
public class BuddyList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "buddy_id")
    @JsonManagedReference
    private User buddy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BudStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getBuddy() {
        return buddy;
    }

    public void setBuddy(User buddy) {
        this.buddy = buddy;
    }

    public BudStatus getStatus() {
        return status;
    }

    public void setStatus(BudStatus status) {
        this.status = status;
    }

    public BuddyList(User user, User buddy, BudStatus status) {
        this.user = user;
        this.buddy = buddy;
        this.status = status;
    }

    public BuddyList() {
    }
}
