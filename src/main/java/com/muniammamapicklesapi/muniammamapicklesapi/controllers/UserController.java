package com.muniammamapicklesapi.muniammamapicklesapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.muniammamapicklesapi.muniammamapicklesapi.enums.response.ResponseEnums;
import com.muniammamapicklesapi.muniammamapicklesapi.models.appuser.AppUserModel;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.user.GetUserDetailsRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.user.UserAddressInformationRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.user.UserPersonalInformationRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.auth.ResponseDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.user.GetUserDetailsResponseDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.repository.UserRepository;
import com.muniammamapicklesapi.muniammamapicklesapi.services.user.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepo;
    @Autowired
    private UserServices userServices;

    @PostMapping("/pdetails")
    public ResponseDTO updateProfileInformation(@RequestBody UserPersonalInformationRequestDTO request) {
        return userServices.updatePersonalInformatin(request);

    }

    @PostMapping("/adetails")
    public ResponseDTO updatAddressInformation(@RequestBody UserAddressInformationRequestDTO request) {
        return userServices.updateAddressInformatin(request);

    }

    @PostMapping("/details")
    public GetUserDetailsResponseDTO getUserDetail(@RequestBody GetUserDetailsRequestDTO request) {
        GetUserDetailsResponseDTO response = new GetUserDetailsResponseDTO();

        try {

            AppUserModel userData = userRepo.findByEmailId(request.getEmailId());
            if (userData == null) {
                response.setData(ResponseEnums.USER_NOT_FOUND);
                return response;
            }

            response.setData(ResponseEnums.SUCCESS);
            response.setUser(userData);
        } catch (Exception e) {

            System.out.println(e);

            response.setData(ResponseEnums.INTERNAL_SERVER_ERROR);
        }

        return response;

    }

}
