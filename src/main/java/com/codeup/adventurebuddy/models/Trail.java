package com.codeup.adventurebuddy.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
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
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;
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


    public Trail(long id, String name, double distanceInMi, double lat, double lng, Address address, int ascent, int descent, String summary, String type, List<Review> reviewsList, User user) {
        this.id = id;
        this.name = name;
        this.distanceInMi = distanceInMi;
        this.lat = lat;
        this.lng = lng;
//        this.address = address;
        this.ascent = ascent;
        this.descent = descent;
        this.summary = summary;
        this.type = type;
        this.reviewsList = reviewsList;
        this.user = user;
    }

    public Trail() {
    }

    public double getDistanceInMi() {
        return distanceInMi;
    }
    @JsonSetter ("length")
    public void setDistanceInMi(double distanceInMi) {
        this.distanceInMi = distanceInMi;
    }

    public long getId() {
        return id;
    }
    @JsonSetter("id")
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }
    @JsonSetter("latitude")
    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }
    @JsonSetter("longitude")
    public void setLng(double lng) {
        this.lng = lng;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public int getAscent() {
        return ascent;
    }
    @JsonSetter("ascent")
    public void setAscent(int ascent) {
        this.ascent = ascent;
    }
    public int getDescent() {
        return descent;
    }
    @JsonSetter("descent")
    public void setDescent(int descent) {
        this.descent = descent;
    }

    public String getSummary() {
        return summary;
    }
    @JsonSetter("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getType() {
        return type;
    }
    @JsonSetter("type")
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

//    @JsonProperty("attributes")
//    public void setTrail(List<Map<String, Object>> trailDetails) {
//        Map<String, Object> attributes = trailDetails.get(0);
//        setId((Long) attributes.get("id"));
//        setName((String) attributes.get("name"));
//        setSummary((String) attributes.get("summary"));
//        setType((String) attributes.get("type"));
//        setDistanceInMi((Double) attributes.get("length"));
//        setAscent((Integer) attributes.get("ascent"));
//        setDescent((Integer) attributes.get("descent"));
//        setLat((Double) attributes.get("latitude"));
//        setLng((Double) attributes.get("longitude"));
//    }
}
