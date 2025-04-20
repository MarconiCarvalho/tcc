package com.faculdade.tcc.service;

import com.faculdade.tcc.Repositories.UserRepository;
import com.faculdade.tcc.domain.dtos.requests.UserRequestDTO;
import com.faculdade.tcc.domain.user.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;



    public User createUser(UserRequestDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public void saveUser(User user){
        this.userRepository.save(user);
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
        Optional<Object> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()){
            User user = (User) existingUser.get();
            user.setName(userRequestDTO.name());
            user.setEmail(userRequestDTO.email());
            user.setRegistration(userRequestDTO.registration());
            user.setRole(userRequestDTO.role());
            return userRepository.save(user);
        }
        return null;
    }
}
