package com.example.demo.App;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer, User> userDB = new HashMap<>();

    public User createUser(User user) {
        System.out.println(user.getName());
        userDB.put(user.getId(), user);
//        return  ResponseEntity.status(HttpStatus.CREATED).body(user);
        return  user;
    }


    public User updateUser(User user) {
        if(!userDB.containsKey(user.getId())){
            return null;
        }else{
            userDB.put(user.getId(),user);
        }
        return user;
    }

    public boolean deleteUser(int id) {
        if(!userDB.containsKey(id)){
            return false;
        }
         userDB.remove(id);
        return true;
    }

    public List<User> getAllUsers() {
        return  new ArrayList<>(userDB.values());
    }
    public User getUserById(int id){
        return userDB.get(id);
    }
}
