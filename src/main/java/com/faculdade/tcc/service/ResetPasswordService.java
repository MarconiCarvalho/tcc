package com.faculdade.tcc.service;
import com.faculdade.tcc.Repositories.TokenPasswordRepository;
import com.faculdade.tcc.domain.resetPassword.TokenPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ResetPasswordService {

    @Autowired
    private TokenPasswordRepository tokenPasswordRepository;

public TokenPassword createPasswordResetToken(UUID userId){

    TokenPassword token = new TokenPassword();

    token.setUserId(userId);
    token.setToken(UUID.randomUUID().toString());
    token.setCreatedAt(LocalDateTime.now());
    token.setExpiresAt(LocalDateTime.now().plusMinutes(15));
    token.setUsed(false);

    return tokenPasswordRepository.save(token);


}

}
