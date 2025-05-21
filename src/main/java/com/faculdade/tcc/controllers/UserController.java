package com.faculdade.tcc.controllers;

import com.faculdade.tcc.repositories.UserRepository;
import com.faculdade.tcc.domain.dtos.requests.UserRequestDTO;
import com.faculdade.tcc.domain.dtos.responses.UserResponseDTO;
import com.faculdade.tcc.domain.user.User;
import com.faculdade.tcc.infra.jwt.JwtUtils;
import com.faculdade.tcc.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserRequestDTO userRequestDTO){
        if (this.userRepository.findByEmail(userRequestDTO.email()).isPresent()) return ResponseEntity.badRequest().build();
        UUID userId = JwtUtils.getUserIdFromToken();
        String encryptedPassword = new BCryptPasswordEncoder().encode(userRequestDTO.password());
        User newUser = new User(userRequestDTO);
        newUser.setCreateBy(userId);
        newUser.setCreateAt(LocalDateTime.now());
        this.userService.saveUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAllUsers(){
        List<User> users = userService.findAllUsers();
        List<UserResponseDTO> response = users.stream().map(UserResponseDTO::new).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable UUID id) throws Exception {
        User user = userService.findUserById(id);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody UserRequestDTO userRequestDTO){
        User updateUser = userService.updateUser(id, userRequestDTO);
        if(updateUser != null){
            return new ResponseEntity<>(updateUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id){
        boolean deleted = userService.deleteUser(id);
        if(deleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
