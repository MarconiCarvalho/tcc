package com.faculdade.tcc.service;

import com.faculdade.tcc.Repositories.UserRepository;
import com.faculdade.tcc.domain.dtos.requests.UserRequestDTO;
import com.faculdade.tcc.domain.user.User;
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



    public User createUser(UserRequestDTO userRequestDTO) {

        User newUser = new User(userRequestDTO);
        newUser.setCreateAt(LocalDateTime.now());
        this.saveUser(newUser);
        return newUser;

    }

    public void saveUser(User user) {
        this.userRepository.save(user);

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

        if (!userRepository.existsById(userRequestDTO.updateBy())){
            user.setUpdateBy(userRequestDTO.updateBy());
        }else {
            throw new RuntimeException("UserUpdater not found");
        }
        user.setName(userRequestDTO.name());
        user.setEmail(userRequestDTO.email());
        user.setRegistration(userRequestDTO.registration());
        user.setRole(userRequestDTO.role());
        user.setUpdateAt(LocalDateTime.now());

        return userRepository.save(user);
    }
}
