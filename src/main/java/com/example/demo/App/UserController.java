package com.example.demo.App;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/User")
public class UserController {

  private  Map<Integer, User> userDB = new HashMap<>();

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user){
      System.out.println(user.getName());
      userDB.put(user.getId(), user);
      return  ResponseEntity.status(HttpStatus.CREATED).body(user);
  }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
      if(!userDB.containsKey(user.getId())){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
      }else{
          userDB.put(user.getId(),user);
      }
      return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }

  @GetMapping("/{id}/{name}")
  public ResponseEntity<User> singleUser(
          @PathVariable("id") int UserId,
          @PathVariable String name){
      if(!userDB.containsKey(UserId)){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity.ok(userDB.get(UserId));

  }
    @GetMapping("/User/{id}/{name}")
    public String getUser(
            @PathVariable int id,
            @PathVariable String name) {

        return "ID: " + id + ", Name: " + name;
    }

  @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
      if(!userDB.containsKey(id)){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not deleted");
      }
            userDB.remove(id);
            return ResponseEntity.status(HttpStatus.FOUND).body("user deleted successfully");
  }
        @GetMapping("/info")
        public  String getUser(@RequestHeader ("user-agent") String userAgent){
      return  "user agent :" + userAgent;
        }

}
