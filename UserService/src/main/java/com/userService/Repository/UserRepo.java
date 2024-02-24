package com.userService.Repository;

import com.userService.Model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepo extends MongoRepository<User, ObjectId> {

    @Query("{username: \"?0\"}")
    User getUserByUserName(String username);
}
