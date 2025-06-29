package com.faculdade.tcc.controllers;

import com.faculdade.tcc.domain.resetPassword.ResetPassword;
import com.faculdade.tcc.domain.email.Email;
import com.faculdade.tcc.producers.EmailProducer;
import com.faculdade.tcc.domain.user.User;
import com.faculdade.tcc.service.EmailService;
import com.faculdade.tcc.service.ResetPasswordService;
import com.faculdade.tcc.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/email")
@Tag(name = "Email", description = "API para gerenciar emails ")
public class EmailController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailProducer emailProducer;
    @Autowired
    private ResetPasswordService resetPasswordService;

    @PostMapping
    @Operation(summary = "Envia link de redefinição com o token para o email", description = "Retorna um HttpStatus")
    public ResponseEntity<String> sendingEmail(@RequestBody Map<String, String> request){
        String email = request.get("email");

        try {
            String token = resetPasswordService.generateToken(email);

            Email emailSend = new Email();
            emailSend.setOwnerRef("API-CATOLICA");
            emailSend.setEmailFrom("marconi.junior.ana10@gmail.com");
            emailSend.setEmailTo(email);
            emailSend.setSubject("Link para redefinição de senha");
            emailSend.setText("Link para redefinição de senha:\n\n" +
                    "http://localhost:8080/email/updatepassword?token=" + token);
            emailProducer.listenPasswordReset(emailSend);

            return new ResponseEntity<>("Email sent successfully!", HttpStatus.CREATED);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/updatepassword")
    @Operation(summary = "Atualiza a senha",description = " recebe o token faz a validação e retorna atualiza a senha e retorna um HttpStatus")
    public ResponseEntity<String> resetPassword(@RequestParam("token") String token,
                                                @RequestBody Map<String, String> body){
        ResetPassword tokenPassword = resetPasswordService.findByToken(token);

        UUID userId = tokenPassword.getUserId();
        User user = userService.findUserById(userId);

        if(user == null){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        String newPassword = body.get("newPassword");
        if(newPassword == null || newPassword.isBlank()){
            return new ResponseEntity<>("New password is mandatory", HttpStatus.BAD_REQUEST);
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(newPassword);
        user.setPassword(encryptedPassword);
        userService.saveUser(user);

        tokenPassword.setUsed(true);
        resetPasswordService.saveToken(tokenPassword);
        return new ResponseEntity<>("password reset successfully", HttpStatus.OK);
    }
}
