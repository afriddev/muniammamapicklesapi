package com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForgotPasswordRequestDTO{
    private String emailId;

}