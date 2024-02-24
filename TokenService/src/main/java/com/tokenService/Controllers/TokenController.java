package com.tokenService.Controllers;

import com.tokenService.Services.TokenService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    // create token by userId
    @GetMapping("/get-token/{id}")
    public String createToken(@PathVariable("id") ObjectId userId){
        return tokenService.createToken(userId);
    }

    // get userId from token
    @GetMapping("/get-userId-from-token/{token}")
    public String getUserIdFromToken(@PathVariable("token") String token){
        return tokenService.getUserIdFromToken(token);
    }
}
