package com.apiGateway.Controllers;

import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("token-service/auth")
public interface TokenController {

    // create token by userId
    @GetMapping("/get-token/{id}")
    public String createToken(@PathVariable("id") ObjectId userId);

    // get userId from token
    @GetMapping("/get-userId-from-token/{token}")
    public String getUserIdFromToken(@PathVariable("token") String token);

}
