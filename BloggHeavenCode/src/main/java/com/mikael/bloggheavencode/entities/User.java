package com.mikael.bloggheavencode.entities;

import com.mikael.bloggheavencode.enums.MemberTypes;

import javax.persistence.*;

/**
 * <code>User</code> - User class that has the information of the user
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Entity
public class User {

    // -----------------------------------------------------------------------------------------------------------------
    //   Properties
    // -----------------------------------------------------------------------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private MemberTypes memberTypes;

    // -----------------------------------------------------------------------------------------------------------------
    //   Constructor
    // -----------------------------------------------------------------------------------------------------------------

    public User() {
    }

    public User(Long id, String firstName, String lastName, String address, String email, String phone, MemberTypes memberTypes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.memberTypes = memberTypes;
    }

    public User(String firstName, String lastName, String address, String email, String phone, MemberTypes memberTypes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.memberTypes = memberTypes;
    }

    // -----------------------------------------------------------------------------------------------------------------
    //   Getter & Setter
    // -----------------------------------------------------------------------------------------------------------------

    public User(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MemberTypes getMemberTypes() {
        return memberTypes;
    }

    public void setMemberTypes(MemberTypes memberTypes) {
        this.memberTypes = memberTypes;
    }
}
