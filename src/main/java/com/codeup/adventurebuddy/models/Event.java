package com.codeup.adventurebuddy.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "trail_id")
    private Trail trail;
    @Column(nullable = false)
    private String date;
    @ManyToOne
    @JoinColumn(name = "host_id")
    private User user;
    @ManyToMany(mappedBy = "events")
    private List<User> userLists;
    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    public Event() { }

    public Event(long id, Trail trail, String date, User user, List<User> userLists) {
        this.id = id;
        this.trail = trail;
        this.date = date;
        this.user = user;
        this.userLists = userLists;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Trail getTrail() {
        return trail;
    }

    public void setTrail(Trail trail) {
        this.trail = trail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserLists() {
        return userLists;
    }

    public void setUserLists(List<User> userLists) {
        this.userLists = userLists;
    }
}
