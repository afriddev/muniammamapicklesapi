package com.muniammamapicklesapi.muniammamapicklesapi.services.auth;

import com.muniammamapicklesapi.muniammamapicklesapi.enums.response.ResponseEnums;

public interface AuthImpl {

    ResponseEnums signUPImpl(SignUpRequestDTO request);

    ResponseEnums loginImpl(LoginRequesDTO request);

    ResponseEnums forgotPasswordImpl(ForgotPasswordRequestDTO request);

    ResponseEnums resetPasswordImpl(ResetPasswordRequestDTO request);

}
