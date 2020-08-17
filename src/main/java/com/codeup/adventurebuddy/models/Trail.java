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
    private double distanceInMI;
    @Column(nullable = false)
    private double lat;
    @Column(nullable = false)
    private double lng;
    @Column(nullable = false)
    private long addressId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trail")
    private List<Review> reviewsList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="activity_trail",
            joinColumns={@JoinColumn(name="activity_id")},
            inverseJoinColumns={@JoinColumn(name="trail_id")}
    )
    private List<Activity> activities;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Trail(long id, String name, double distanceInMI, double lat, double lng, long addressId) {
        this.id = id;
        this.name = name;
        this.distanceInMI = distanceInMI;
        this.lat = lat;
        this.lng = lng;
        this.addressId = addressId;
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
        return distanceInMI;
    }

    public void setDistanceInMI(double distanceInMI) {
        this.distanceInMI = distanceInMI;
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

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public Trail() {
    }
}
