package com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequesDTO {
    private String emailId;
    private String password; 
    private Integer otp;
    private boolean googleLogin;
    private String firstName;
    private String profileUrl;
}
