package com.userService.Controllers;

import com.userService.ExceptionHandling.BadRequestException;
import com.userService.ExceptionHandling.UserException;
import com.userService.Model.User;
import com.userService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllers {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public User createUser(@RequestBody User user)throws BadRequestException {
        User user1=userService.registerUser(user);
        return user1;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) throws UserException,BadRequestException {
        String userName = user.getUsername();
        String userPassword = user.getPassword1();
        return userService.userLogin(userName, userPassword);
    }

    @GetMapping("/getallusers")
    public List<User>getAllUser(){
        List<User>alluser=userService.getAllUser();
        return alluser;
    }

}
