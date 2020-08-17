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
    private long trailId;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private long hostId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "events")
    private List<User> userLists;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTrailId() {
        return trailId;
    }

    public void setTrailId(long trailId) {
        this.trailId = trailId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getHostId() {
        return hostId;
    }

    public void setHostId(long hostId) {
        this.hostId = hostId;
    }

    public Event(long id, long trailId, String date, long hostId) {
        this.id = id;
        this.trailId = trailId;
        this.date = date;
        this.hostId = hostId;
    }

    public Event() {
    }
}
