package com.muniammamapicklesapi.muniammamapicklesapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muniammamapicklesapi.muniammamapicklesapi.enums.response.ResponseEnums;
import com.muniammamapicklesapi.muniammamapicklesapi.models.appuser.AppUserModel;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.auth.ForgotPasswordRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.auth.LoginRequesDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.auth.ResetPasswordRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.auth.SignUpRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.auth.LoginResponseDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.auth.ResponseDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.repository.AuthRepository;
import com.muniammamapicklesapi.muniammamapicklesapi.services.auth.AuthServices;

@RestController
@RequestMapping("/auth")
public class AuthControlller {

    @Autowired
    AuthServices auth;

    @Autowired
    AuthRepository authRepo;

    @PostMapping("/signup")
    ResponseDTO SignUp(@RequestBody SignUpRequestDTO request) {

        ResponseDTO response = new ResponseDTO();
        if (request.getFirstName() == null || request.getEmailId() == null) {
            response.setData(ResponseEnums.BAD_REQUEST);
            return response;
        }

        response.setData(auth.signUPImpl(request));
        return response;
    }

    @PostMapping("/login")
    LoginResponseDTO Login(@RequestBody LoginRequesDTO request) {
        LoginResponseDTO response = new LoginResponseDTO();
        if (request.getEmailId() == null) {
            response.setData(ResponseEnums.BAD_REQUEST);
            return response;
        }

        ResponseEnums loginImplResposne = auth.loginImpl(request);

        response.setData(loginImplResposne);

        if (loginImplResposne == ResponseEnums.SUCCESS) {
            AppUserModel userData = authRepo.findByEmailId(request.getEmailId());
            if (userData != null) {
                response.setAddressFilled((userData.getAddress() == null));
            }
        }
        return response;
    }

    @PostMapping("/forgotpassword")
    ResponseDTO forgotPassword(@RequestBody ForgotPasswordRequestDTO request) {
        ResponseDTO response = new ResponseDTO();
        if (request.getEmailId() == null) {
            response.setData(ResponseEnums.BAD_REQUEST);
            return response;
        }
        ResponseEnums loginImplResposne = auth.forgotPasswordImpl(request);
        response.setData(loginImplResposne);

        return response;
    }

    @PostMapping("/resetpassword")
    ResponseDTO resetPassword(@RequestBody ResetPasswordRequestDTO request) {
        ResponseDTO response = new ResponseDTO();
        if (request.getPassword() == null) {
            response.setData(ResponseEnums.BAD_REQUEST);
            return response;
        }
        response.setData(auth.resetPasswordImpl(request));
        return response;
    }

}
