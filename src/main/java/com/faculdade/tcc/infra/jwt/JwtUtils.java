package com.faculdade.tcc.infra.jwt;

import com.faculdade.tcc.domain.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public class JwtUtils {

    public static UUID getUserIdFromToken(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof UserDetails){
           User userDetails = (User) authentication.getPrincipal();
            return userDetails.getId();
        }
        return null;
    }
}
