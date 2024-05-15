package com.hroom.user.convertor;

import com.hroom.user.dto.SignUpRequest;
import com.hroom.user.entity.Admin;
import com.hroom.user.entity.Landlord;
import com.hroom.user.entity.Tenant;
import com.hroom.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User signUpRequestToUser(SignUpRequest signUpRequest){
        User user;
        String role = signUpRequest.getRole();
        switch (role) {
                case "admin":
                        user = new Admin();
                        break;
                case "tenant":
                        user = new Tenant();
                        break;
                case "landlord":
                        user = new Landlord();
                        break;
                default:
                        user = new Tenant();
        }
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(signUpRequest.getPassword());
        user.setPhoneNumber(signUpRequest.getPhoneNumber());
        user.setName(signUpRequest.getName());
        user.setSurname(signUpRequest.getSurname());
        user.setEmail(signUpRequest.getEmail());

        return user;
    }
}
