package com.faculdade.tcc.service;

import com.faculdade.tcc.Repositories.UserRepository;
import com.faculdade.tcc.domain.dtos.requests.UserRequestDTO;
import com.faculdade.tcc.domain.user.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;



    public User createUser(UserRequestDTO userRequestDTO) {

        User newUser = new User();

        newUser.setName(userRequestDTO.name());
        newUser.setEmail(userRequestDTO.email());
        newUser.setRegistration(userRequestDTO.registration());
        newUser.setRole(userRequestDTO.role());

        if (userRequestDTO.createBy() != null) {
            User creator = (User) userRepository.findById(userRequestDTO.createBy())
                    .orElseThrow(() -> new RuntimeException("Created Id not found"));
            newUser.setCreateBy(creator);
        }

        newUser.setCreateAt(LocalDateTime.now());
        return userRepository.save(newUser);

    }

    public User saveUser(User user){
        this.userRepository.save(user);
        return user;
    }


    public List<User> findAllUsers(){
        return this.userRepository.findAll();
    }


    public User findUserById(UUID id) throws Exception {
        return (User) this.userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
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
        User user = (User) userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with ID: "+ id + " not found"));

        User updater = (User) userRepository.findById(userRequestDTO.updateBy())
                .orElseThrow(() -> new RuntimeException("User updater not found"));

        user.setName(userRequestDTO.name());
        user.setEmail(userRequestDTO.email());
        user.setRegistration(userRequestDTO.registration());
        user.setRole(userRequestDTO.role());

        user.setUpdateBy(updater);
        user.setUpdateAt(LocalDateTime.now());

        return userRepository.save(user);
    }
}
