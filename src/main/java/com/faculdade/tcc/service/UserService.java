package com.faculdade.tcc.service;

import com.faculdade.tcc.Repositories.UserRepository;
import com.faculdade.tcc.domain.dtos.UserDTO;
import com.faculdade.tcc.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO data){
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

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
    }

    public void deleteUser(Long id)  {
        this.userRepository.deleteById(id);
    }

}
