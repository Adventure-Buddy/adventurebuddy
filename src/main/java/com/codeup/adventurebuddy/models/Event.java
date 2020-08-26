package com.codeup.adventurebuddy.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="events")
public class Event {

//    private Set<UserEvent> userEvents = new HashSet<UserEvent>();

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
    @Column(nullable = false)
    private boolean isFull;
    @ManyToOne
    @JoinColumn(name = "host_id")
    private User user;

    @OneToMany(mappedBy = "event")
    private List<UserEvent> userEvents = new ArrayList<>();

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

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public boolean getFull() {
        return isFull;
    }
}
