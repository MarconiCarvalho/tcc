package com.faculdade.tcc.service;

import com.faculdade.tcc.domain.email.Email;
import com.faculdade.tcc.producers.EmailProducer;
import com.faculdade.tcc.repositories.UserRepository;
import com.faculdade.tcc.domain.dtos.requests.UserRequestDTO;
import com.faculdade.tcc.domain.user.User;
import com.faculdade.tcc.infra.jwt.JwtUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailProducer emailProducer;


    public void saveUser(User user) {
        this.userRepository.save(user);

    }


    public User createUser(UserRequestDTO userRequestDTO) {
        Email newEmail = new Email();
        User newUser = new User(userRequestDTO);
        String password = UUID.randomUUID().toString();

        newUser.setPassword(password);
        saveUser(newUser);

        newEmail.setOwnerRef("API-CATOLICA");
        newEmail.setEmailTo(userRequestDTO.email());
        newEmail.setEmailFrom("marconi.junior.ana@gmail.com");
        newEmail.setSubject("Password: ");
        newEmail.setText("Sua senha: " + password);
        emailProducer.listenAccountCreated(newEmail);
        return newUser;

    }

    public List<User> findAllUsers(){
        return this.userRepository.findAll();
    }


    public User findUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User findUserByEmail(String email){
        return (User) userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }


    @Transactional
    public boolean deleteUser(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public User updateUser(UUID id, UserRequestDTO userRequestDTO){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with ID: "+ id + " not found"));
        UUID updateBy = JwtUtils.getUserIdFromToken();

        user.setUpdateBy(updateBy);
        user.setName(userRequestDTO.name());
        user.setEmail(userRequestDTO.email());
        user.setRegistration(userRequestDTO.registration());
        user.setRole(userRequestDTO.role());
        user.setUpdateAt(LocalDateTime.now());

        return userRepository.save(user);
    }
}
