package com.muniammamapicklesapi.muniammamapicklesapi.services.user;

import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.user.UserAddressInformationRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.user.UserPersonalInformationRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.auth.ResponseDTO;

public interface UserImpl {
    public ResponseDTO updatePersonalInformatin(UserPersonalInformationRequestDTO request);

    public ResponseDTO updateAddressInformatin(UserAddressInformationRequestDTO request);

}
