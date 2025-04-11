package com.faculdade.tcc.Controllers;

import com.faculdade.tcc.domain.dtos.requests.UserRequestDTO;
import com.faculdade.tcc.domain.dtos.responses.UserResponseDTO;
import com.faculdade.tcc.domain.user.User;
import com.faculdade.tcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequestDTO user, UserResponseDTO response){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAllUsers(){
        List<User> users = userService.findAllUsers();
        List<UserResponseDTO> response = users.stream().map(UserResponseDTO::new).toList();
        return ResponseEntity.ok(response);
    }
}
