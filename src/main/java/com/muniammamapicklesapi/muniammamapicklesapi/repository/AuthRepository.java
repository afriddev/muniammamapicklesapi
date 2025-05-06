package  com.muniammamapicklesapi.muniammamapicklesapi.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import com.muniammamapicklesapi.muniammamapicklesapi.models.appuser.AppUserModel;
import com.muniammamapicklesapi.muniammamapicklesapi.models.appuser.ResetPassword;


@Repository
public interface AuthRepository extends MongoRepository<AppUserModel, String> {

    public AppUserModel findByEmailId(String emailId);

    @Query("{ 'emailId' : ?0 }")
    @Update("{ '$set' : { 'otp' : ?1 } }")
    int findAndUpdateOtp(String emailId, int otp);

    @Query("{ 'emailId' : ?0 }")
    @Update("{ '$set' : { 'resetPassword' : ?1 } }")
    int findAndUpdateresetPassword(String emailId, ResetPassword resetPassword);

    @Query("{ 'resetPassword.resetPasswordToken' : ?0 }")
    Optional<AppUserModel> findByResetPasswordToken(String token);


    @Query("{ 'emailId' : ?0 }")
    @Update("{ '$set' : { 'password' : ?1 } }")
    int findAndUpdatePassword(String emailId, String passwp);

}
