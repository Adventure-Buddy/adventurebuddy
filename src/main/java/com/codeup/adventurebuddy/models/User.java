package com.codeup.adventurebuddy.models;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 45, unique = true)
    private String username;
    @Column(nullable = false, length = 110)
    private String email;
    @Column(nullable = false, length = 50)
    private String password;
    @Column(nullable = true, length = 20)
    private String phoneNumber;
    @Column(nullable = false, length = 15)
    private String dateOfBirth;
    @Column(nullable = false)
    private long addressId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<EmergencyContact> emergencyContactsList;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Address> addressList;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Review> reviewsList;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Trail> trailsList;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Event> eventsList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="event_user",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="event_id")}
    )
    private List<Event> events;

    public User(long id, String username, String email, String password, String phoneNumber, String dateOfBirth, long addressId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.addressId = addressId;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public List<EmergencyContact> getEmergencyContactsList() {
        return emergencyContactsList;
    }

    public void setEmergencyContactsList(List<EmergencyContact> emergencyContactsList) {
        this.emergencyContactsList = emergencyContactsList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Review> getReviewsList() {
        return reviewsList;
    }

    public void setReviewsList(List<Review> reviewsList) {
        this.reviewsList = reviewsList;
    }

    public List<Trail> getTrailsList() {
        return trailsList;
    }

    public void setTrailsList(List<Trail> trailsList) {
        this.trailsList = trailsList;
    }

    public List<Event> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<Event> eventsList) {
        this.eventsList = eventsList;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public abstract Collection<? extends GrantedAuthority> getAuthority();
}
