package com.muniammamapicklesapi.muniammamapicklesapi.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muniammamapicklesapi.muniammamapicklesapi.enums.response.ResponseEnums;
import com.muniammamapicklesapi.muniammamapicklesapi.models.appuser.AppUserModel;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.user.UserAddressInformationRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.user.UserPersonalInformationRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.auth.ResponseDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.repository.UserRepository;

@Service
public class UserServices implements UserImpl {

    @Autowired
    UserRepository userRepo;

    public ResponseDTO updatePersonalInformatin(UserPersonalInformationRequestDTO request) {
        ResponseDTO response = new ResponseDTO();
        try {

            AppUserModel userData = userRepo.findByEmailId(request.getEmailId());

            if (userData == null) {
                response.setData(ResponseEnums.USER_NOT_FOUND);
            }
            int updatedresult = userRepo.findByEmailIdAndUpdate(request.getEmailId(), request.getName(),
                    request.getPhoneNumber(), request.getBio());

            response.setData(ResponseEnums.SUCCESS);

        } catch (Exception e) {
            System.out.println(e);
            response.setData(ResponseEnums.INTERNAL_SERVER_ERROR);

        }
        return response;

    }

    public ResponseDTO updateAddressInformatin(UserAddressInformationRequestDTO request) {
        ResponseDTO response = new ResponseDTO();
        try {

            AppUserModel userData = userRepo.findByEmailId(request.getEmailId());

            if (userData == null) {
                response.setData(ResponseEnums.USER_NOT_FOUND);
            }
            int updatedresult = userRepo.findByEmailIdAndUpdateAddress(request.getEmailId(), request.getAddressLine1(),
                    request.getAddressLine2(), request.getCity(), request.getState(), request.getPincode(),
                    request.getCountry());

            response.setData(ResponseEnums.SUCCESS);

        } catch (Exception e) {
            System.out.println(e);
            response.setData(ResponseEnums.INTERNAL_SERVER_ERROR);

        }
        return response;
    }

}
