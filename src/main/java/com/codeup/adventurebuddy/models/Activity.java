package com.codeup.adventurebuddy.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activity")
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Activity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Activity() {
    }
}
