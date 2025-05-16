package com.faculdade.tcc.Controllers;

import com.faculdade.tcc.EmailPassword.domain.Email;
import com.faculdade.tcc.EmailPassword.domain.ResetPassword;
import com.faculdade.tcc.EmailPassword.producers.EmailProducer;
import com.faculdade.tcc.domain.user.User;
import com.faculdade.tcc.service.EmailService;
import com.faculdade.tcc.service.ResetPasswordService;
import com.faculdade.tcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/email")
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
                    "http://localhost:8080/updatepassword?token=" + token);

            System.out.println(email);
            System.out.println(emailSend.getEmailFrom());
            emailProducer.publishMessage(emailSend);

            return new ResponseEntity<>("Email sent successfully!", HttpStatus.CREATED);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/updatepassword")
    public ResponseEntity<String> resetPassword(@RequestParam("token") String token,
                                                @RequestBody Map<String, String> body){
        ResetPassword tokenPassword = resetPasswordService.findByToken(token);
        if(tokenPassword == null){
            return new ResponseEntity<>("Token invalid.", HttpStatus.BAD_REQUEST);
        }
        if(tokenPassword.isUsed()){
            return new ResponseEntity<>("Token Used",HttpStatus.BAD_REQUEST);
        }
        if(tokenPassword.getExpiresAt().isBefore(LocalDateTime.now())){
            return new ResponseEntity<>("Token expired.", HttpStatus.BAD_REQUEST);
        }

        UUID userId = tokenPassword.getUserId();
        User user = userService.findUserById(userId);

        if(user == null){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        String newPassword = body.get("newPassword");
        if(newPassword == null || newPassword.isBlank()){
            return new ResponseEntity<>("New password is mandatory", HttpStatus.BAD_REQUEST);
        }

        user.setPassword(newPassword);
        userService.saveUser(user);

        tokenPassword.setUsed(true);
        resetPasswordService.saveToken(tokenPassword);
        return new ResponseEntity<>("password reset successfully", HttpStatus.OK);
    }
}
