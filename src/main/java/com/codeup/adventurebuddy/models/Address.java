package com.codeup.adventurebuddy.models;

import javax.persistence.*;

@Entity
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = true)
    private String addressOne;
    @Column(nullable = true)
    private String addressTwo;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;
    @Column(nullable = true)
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToOne(mappedBy = "address")
//    private Trail trail;

    public Address(long id, String addressOne, String addressTwo, String city, String state, String zipCode) {
        this.id = id;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//
//    public Trail getTrail() {
//        return trail;
//    }

//    public void setTrail(Trail trail) {
//        this.trail = trail;
//    }
}
