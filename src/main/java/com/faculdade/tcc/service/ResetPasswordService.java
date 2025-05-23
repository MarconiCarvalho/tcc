package com.faculdade.tcc.service;

import com.faculdade.tcc.controllers.ResetPassword;
import com.faculdade.tcc.repositories.ResetPasswordRepository;
import com.faculdade.tcc.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ResetPasswordService {

    @Autowired
    private ResetPasswordRepository resetRepository;
    @Autowired
    private UserService userService;

    public void saveToken(ResetPassword resetPassword) {
        this.resetRepository.save(resetPassword);
    }

    public String generateToken(String email){
        User userToken = userService.findUserByEmail(email);

        if (userToken == null){
            throw new RuntimeException("User with e-mail " +email + " não encontrado.");
        }
        String token = UUID.randomUUID().toString();
        ResetPassword generateToken = new ResetPassword();
        generateToken.setToken(token);
        generateToken.setUserId(userToken.getId());
        generateToken.setCreateAt(LocalDateTime.now());
        generateToken.setUsed(false);
        generateToken.setExpiresAt(LocalDateTime.now().plusMinutes(15));

        resetRepository.save(generateToken);
        return token;
    }

    public void validateToken(String token){
        ResetPassword tokenPassword = findByToken(token);
        if(tokenPassword == null){
            new RuntimeException("Invalid Token");
        }
        if(tokenPassword.isUsed()){
            new RuntimeException("Used Token");
        }
        if(tokenPassword.getExpiresAt().isBefore(LocalDateTime.now())){
            new RuntimeException("Expirad Token");
        }
    }
    public ResetPassword findByToken(String token){
        return this.resetRepository.findByToken(token);
    }

}
