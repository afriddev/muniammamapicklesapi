package com.muniammamapicklesapi.muniammamapicklesapi.models.appuser;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.muniammamapicklesapi.muniammamapicklesapi.enums.response.RoleEnums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "app_users")
/**
 * AppUserModel is a model class that represents an application user. It
 * contains various fields related to the user's information.
 */
public class AppUserModel {

    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String mobileNumber;
    private Integer otp;
    private String bio;
    private boolean googleSignUp;
    private String profileUrl;
    private boolean firstTimeLogin = true;
    ResetPassword resetPassword;
    private String ca;
    private String ck;
    private boolean islLoggedIn;
    private RoleEnums role = RoleEnums.USER;
    AddressModel address;
    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}
