package com.codeup.adventurebuddy.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="events")
public class Event {

//    private Set<UserEvent> userEvents = new HashSet<UserEvent>();

    private List<UserEvent> userEvents = new ArrayList<>();

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
    @Column(nullable = false)
    private int roomSize;
    @ManyToOne
    @JoinColumn(name = "host_id")
    private User user;

    @OneToMany(mappedBy = "event")
    public List<UserEvent> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(List<UserEvent> events) {
        this.userEvents = events;
    }

    public void addUserEvent(UserEvent userEvent) {
        this.userEvents.add(userEvent);
    }

    public Event() { }

    public Event(long id, Trail trail, String date) {
        this.id = id;
        this.trail = trail;
        this.date = date;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
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

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    //    public List<User> getUserLists() {
//        return userLists;
//    }
//
//    public void setUserLists(List<User> userLists) {
//        this.userLists = userLists;
//    }
}
