package com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPersonalInformationRequestDTO {
    private String emailId;
    private String name;
    private String phoneNumber;
    private String bio;
    private String profileUrl;

}
