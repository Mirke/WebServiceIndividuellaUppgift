package com.mikael.bloggheavencode.entities;

import javax.persistence.*;

@Entity
public class Address {

    // -----------------------------------------------------------------------------------------------------------------
    //   Properties
    // -----------------------------------------------------------------------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String street;
    private String postalCode;
    private String city;
    private String country;

    // -----------------------------------------------------------------------------------------------------------------
    //   Constructor
    // -----------------------------------------------------------------------------------------------------------------

    public Address() {
    }

    public Address(Long id, String street, String postalCode, String city, String country) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public Address(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    // -----------------------------------------------------------------------------------------------------------------
    //   Getter & Setter
    // -----------------------------------------------------------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}