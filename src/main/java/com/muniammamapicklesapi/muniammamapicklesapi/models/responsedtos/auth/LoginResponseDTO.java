package com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private Object data;
    private boolean addressFilled;

}
