package com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.user;

import com.muniammamapicklesapi.muniammamapicklesapi.models.appuser.AppUserModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserDetailsResponseDTO {
    private Object data;
    private AppUserModel user;
}
