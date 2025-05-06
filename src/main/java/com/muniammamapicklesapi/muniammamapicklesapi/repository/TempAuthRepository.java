package  com.muniammamapicklesapi.muniammamapicklesapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;


public interface TempAuthRepository extends MongoRepository<TempAppUserModel,String> {

    TempAppUserModel findByEmailId(String emailId);
    TempAppUserModel deleteByEmailId(String emailId);

    @Query("{ 'emailId' : ?0 }")
    @Update("{ '$set' : { 'otp' : ?1 } }")
    int findAndUpdateOtp(String emailId, int otp);



    
}
