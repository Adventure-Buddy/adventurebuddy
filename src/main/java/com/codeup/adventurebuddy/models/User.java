package com.codeup.adventurebuddy.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.awt.desktop.UserSessionEvent;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(10) UNSIGNED")
    private long id;

    @Column(length = 50, nullable = true)
    private String firstName;

    @Column(length = 50, nullable = true)
    private String lastName;

    @Column(nullable = false, length = 45, unique = true)
    private String username;

    @Column(nullable = true, length = 110)
    private String email;

    @Column(nullable = false, length = 250)
    private String password;

    @Column(nullable = true, length = 20)
    private String phoneNumber;

    @Column(nullable = true, length = 15)
    private String dateOfBirth;

    @Column(nullable = true)
    private long addressId;

    @Column(nullable = false, length = 200)
    private String profile_img;

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    private boolean isEnabled;

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

    public User(long id, String username, String email, String password, String phoneNumber, String dateOfBirth, long addressId, boolean isEnabled) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.addressId = addressId;
    }

    public User() {
    }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        firstName = copy.firstName;
        lastName = copy.lastName;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getFirstName(){ return firstName;}

    public void setLastName(String lastName){this.lastName = lastName;}

    public String getLastName() { return lastName; }

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

    public boolean isEnabled(){ return isEnabled;}

    public void setEnabled(boolean enabled){ isEnabled = enabled; }

}
