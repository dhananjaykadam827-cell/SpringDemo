package com.example.demo.App;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    private UserService  userService= new UserService();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

  }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
      User user1 = userService.updateUser(user);
      if(user1 == null){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return  ResponseEntity.status(HttpStatus.FOUND).body(user1);
  }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable int id){
        boolean isDeleted = userService.deleteUser(id);
        if(!isDeleted)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.FOUND).body(id);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

  @GetMapping("/{id}/{name}")
  public ResponseEntity<User> singleUser(@PathVariable("id") int UserId){
      User user = userService.getUserById(UserId);
      if (user == null){
          ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity.status(HttpStatus.FOUND).body(user);

  }
    @GetMapping("/User/{id}/{name}")
    public String getUser(
            @PathVariable int id,
            @PathVariable String name) {

        return "ID: " + id + ", Name: " + name;
    }


        @GetMapping("/info")
        public  String getUser(@RequestHeader ("user-agent") String userAgent){
      return  "user agent :" + userAgent;
        }

}
