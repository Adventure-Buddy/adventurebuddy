package com.codeup.adventurebuddy.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="trails")
public class Trail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double distanceInMi;
    @Column(nullable = false)
    private double lat;
    @Column(nullable = false)
    private double lng;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Column(nullable = false)
    private int ascent;
    @Column(nullable = false)
    private int descent;
    @Column(nullable = true)
    private String summary;
    @Column(nullable = false)
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trail")
    private List<Review> reviewsList;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Trail(long id, String name, double distanceInMI, double lat, double lng, Address address, int ascent, int descent, String summary, String type, List<Review> reviewsList, List<Activity> activities, User user) {
        this.id = id;
        this.name = name;
        this.distanceInMi = distanceInMI;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
        this.ascent = ascent;
        this.descent = descent;
        this.summary = summary;
        this.type = type;
        this.reviewsList = reviewsList;
        this.user = user;
    }

    public Trail() {
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

    public double getDistanceInMI() {
        return distanceInMi;
    }

    public void setDistanceInMI(double distanceInMI) {
        this.distanceInMi = distanceInMI;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAscent() {
        return ascent;
    }

    public void setAscent(int ascent) {
        this.ascent = ascent;
    }

    public int getDescent() {
        return descent;
    }

    public void setDescent(int descent) {
        this.descent = descent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Review> getReviewsList() {
        return reviewsList;
    }

    public void setReviewsList(List<Review> reviewsList) {
        this.reviewsList = reviewsList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
