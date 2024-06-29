package com.DataBase.Sorgu.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserService userService;


    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUser() {

        try {
            return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();

    }



    @PostMapping("create7")
    public ResponseEntity<User> createUser5(@RequestBody User user) {
        User createdUser = userService.createUser5(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }
    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteUser(@RequestBody User user){
        userRepository.delete(user);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @PutMapping("update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        if (updateUser != null) {
            return new ResponseEntity<>(updateUser, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(updateUser, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
        User createUser = userService.createUser(userDto);
        return new  ResponseEntity<>(createUser,HttpStatus.CREATED);
    }
    @GetMapping("/userPage")
    public Page<User> getUsers(@RequestParam(defaultValue = "0")int page,
                               @RequestParam(defaultValue = "5")int size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return userRepository.findAll(pageRequest);
    }
    @GetMapping("/users/byName")
    public List<User> getUsersByName(@RequestParam String name){
        return userService.getUsersByName(name);
    }
}