package com.codeup.adventurebuddy.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "users_events", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "event_id"})})
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(10) UNSIGNED")
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(nullable = false)
    private boolean isAccepted;

    public UserEvent() {}

    public UserEvent(User user, Event event, boolean isAccepted) {
        this.user = user;
        this.event = event;
        this.isAccepted = isAccepted;
    }

    public UserEvent(UserEvent copy) {
        this.id = copy.id;
        this.user = copy.user;
        this.event = copy.event;
        this.isAccepted = copy.isAccepted;

    }

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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        this.isAccepted = accepted;
    }

}
