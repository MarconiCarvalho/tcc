package com.faculdade.tcc.Controllers;

import com.faculdade.tcc.Repositories.UserRepository;
import com.faculdade.tcc.domain.dtos.requests.AuthenticationDTO;
import com.faculdade.tcc.domain.dtos.requests.UserRequestDTO;
import com.faculdade.tcc.domain.dtos.responses.LoginResponseDTO;
import com.faculdade.tcc.domain.user.User;
import com.faculdade.tcc.infra.security.TokenService;
import com.faculdade.tcc.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(),authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register/users")
    public ResponseEntity<User> registerStudent(@RequestBody @Valid UserRequestDTO userRequestDTO){
        if (this.userRepository.findByEmail(userRequestDTO.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(userRequestDTO.password());
        User newUser = new User(
                userRequestDTO.name(),
                userRequestDTO.registration(),
                userRequestDTO.email(),
                encryptedPassword,
                userRequestDTO.role(),
                userRequestDTO.createBy());
        newUser.setCreateAt(LocalDateTime.now());
        this.userService.saveUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
