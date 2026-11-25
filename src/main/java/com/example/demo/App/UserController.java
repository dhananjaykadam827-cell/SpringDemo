package com.example.demo.App;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/User")
public class UserController {

  private  Map<Integer, User> userDB = new HashMap<>();

  @PostMapping
  public String createUser(@RequestBody User user){
      System.out.println(user.getName());
      userDB.put(user.getId(), user);
      return "User Created";
  }

}
