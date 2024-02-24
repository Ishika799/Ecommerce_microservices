package com.userService.Services;

import com.userService.Model.User;
import com.userService.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User registerUser(User user) {
        return userRepo.save(user);
    }

    public String userLogin(String username,String password){
        boolean foundUsers = existByEmail(username);
        if(foundUsers) {
            User userObj = userRepo.getUserByUserName(username);
            if(userObj.getPassword1().equals(password) || userObj.getPaasword2().equals(password)){

                return "{" +
                        "\"message\":"+"Successfully logged in\",\n"+
                        "\"data\":"+userObj+",\n"+
                        "\"Email: "+ userObj.getEmail()+"\n"+
                        "\""+
                        "}";
            }
        }

        return "{" +
                "\"message\":"+"Authentication failed\",\n"+
                "}";
    }
    public Boolean existByEmail(String email){
        Optional<User> usersObj = Optional.ofNullable(userRepo.getUserByUserName(email));
        //List<User> usersObj= userRepoObj.getUserByUsername(email);
        if(!usersObj.isEmpty()){
            return true;
        }
        return false;
    }



    public List<User> getAllUser() {
        return userRepo.findAll();
    }



}
