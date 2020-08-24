package com.codeup.adventurebuddy.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
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
    @Column(nullable = false)
    private String activity;
    @ManyToOne
    @JoinColumn(name = "host_id")
    private User user;
    @ManyToMany(mappedBy = "events")
    private List<User> userLists;
//    @OneToMany(mappedBy = "events")
//    @JsonBackReference
//    private List<UserEvents> UserEvents;

    public Event() { }

    public Event(long id, Trail trail, String date, User user, List<User> userLists) {
        this.id = id;
        this.trail = trail;
        this.date = date;
        this.user = user;
        this.userLists = userLists;
    }

    public String getActivity() {
        return activity;
    }
//    @JsonSetter("activity")

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getTitle() {
        return title;
    }
//    @JsonSetter("title")

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
//    @JsonSetter("description")

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }
//    @JsonSetter("id")

    public void setId(long id) {
        this.id = id;
    }

    public Trail getTrail() {
        return trail;
    }
//    @JsonSetter("Trail")

    public void setTrail(Trail trail) {
        this.trail = trail;
    }

    public String getDate() { return date; }
//    @JsonSetter("date")

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }
//    @JsonSetter("user")
    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserLists() {
        return userLists;
    }

    public void setUserLists(List<User> userLists) {
        this.userLists = userLists;
    }

//    public List<UserEvents> getUserEvents(){
//        return UserEvents;
//    }

//    public void setUserEvents(List<UserEvents> userEvents){
//        this.UserEvents = userEvents;
//    }

}
