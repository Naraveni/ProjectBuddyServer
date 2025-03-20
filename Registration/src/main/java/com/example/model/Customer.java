package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "[6789][0-9]{9}$", message = "Contact number must be 10 digits / contact number must start with 6/7/8/9")
    private String contactNo;  // Validates phone number to be exactly 10 digits

    @NotBlank(message = "Email is required")
    @Column(unique = true)
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@gmail\\.com$", message = "Email must be a valid Gmail address")
    private String email;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotBlank(message = "Password is required")
    private String password;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", contactNo=" + contactNo + ", email=" + email + ", name=" + name + ", password="
                + password + "]";
    }
}
