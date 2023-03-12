package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo ;
    @Autowired
    private ModelMapper modelMapper;

    //save user
    public UserDTO saveUser(UserDTO userDTO){
            userRepo.save(modelMapper.map(userDTO, User.class));  //call the UserRepo which has save method
        //modelMapper pass the userDTO object to User object

            return userDTO ;
    }

    //get all
        public List<UserDTO> getAllUsers(){
            List<User>userList = userRepo.findAll();
            return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
        }

    //update user
       public UserDTO updateuser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
       }

    //delete user
    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO,User.class));
        return true ;
    }

}