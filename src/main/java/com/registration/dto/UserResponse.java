package com.registration.dto;

public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String dateOfBirth;
    private String gender;
    private String address;

    public UserResponse() {
    }

    public UserResponse(
            Long id,
            String name,
            String email,
            String phone,
            String dateOfBirth,
            String gender,
            String address) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }
}