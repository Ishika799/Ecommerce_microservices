package com.apiGateway.Controllers;

import com.apiGateway.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("user-service/user")
public interface UserController {

    // register user
    @PostMapping("/registration")
    public User createUser(@RequestBody User user);

    // login user
    @PostMapping("/login")
    public String login(@RequestBody User user);

    // get all users
    @GetMapping("/getallusers")
    public List<User> getAllUser();

}
