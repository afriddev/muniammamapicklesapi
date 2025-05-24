package com.muniammamapicklesapi.muniammamapicklesapi.repository;

import com.muniammamapicklesapi.muniammamapicklesapi.models.appuser.AppUserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<AppUserModel, String> {
    public AppUserModel findByEmailId(String emailId);

    @Query("{ 'emailId' : ?0 }")
    @Update("{ '$set' : { 'firstName' : ?1,'mobileNumber':?2,'bio':?3} }")
    public int findByEmailIdAndUpdate(String emailId, String name, String mobileNumber, String bio);

    @Query("{ 'emailId' : ?0 }")
    @Update("{ '$set' : { 'address.addressLine1' : ?1,'address.addressLine2':?2,'address.city':?3,'address.state':?4,'address.pincode':?5,'address.country':?6} }")
    public int findByEmailIdAndUpdateAddress(String emailId, String ad1, String ad2, String city, String state, String pincode,
            String country);

}
