package com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.user;

import com.muniammamapicklesapi.muniammamapicklesapi.enums.RoleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigRoleRequestDto {
    private String userName;
    private RoleEnum role; 
}
