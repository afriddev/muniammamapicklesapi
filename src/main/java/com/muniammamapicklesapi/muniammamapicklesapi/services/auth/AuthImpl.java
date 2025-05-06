package com.muniammamapicklesapi.muniammamapicklesapi.services.auth;

import com.muniammamapicklesapi.muniammamapicklesapi.enums.response.ResponseEnums;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.auth.ForgotPasswordRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.auth.LoginRequesDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.auth.ResetPasswordRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.auth.SignUpRequestDTO;

public interface AuthImpl {

    ResponseEnums signUPImpl(SignUpRequestDTO request);

    ResponseEnums loginImpl(LoginRequesDTO request);

    ResponseEnums forgotPasswordImpl(ForgotPasswordRequestDTO request);

    ResponseEnums resetPasswordImpl(ResetPasswordRequestDTO request);

}
