package com.sda.store.user;

import com.sda.store.commons.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class UserService {

    //    @Autowired
//    private UserRepository userRepository;
//
//    public UserEntity saveUser(UserEntity userEntity){
//        return userRepository.save(userEntity);
//    }
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    //@Secured("ADMIN")
    public List<UserDto> getAllUsers() {
        Iterable<UserEntity> allUsers = userRepository.findAll();
        return StreamSupport.stream(allUsers.spliterator(), false)
                .map(userEntity -> modelMapper.map(userEntity, UserDto.class))
                .collect(Collectors.toList());
    }


    public List<UserDto> getAllUsersJava7() {
        Iterable<UserEntity> allUsers = userRepository.findAll();
        Iterator<UserEntity> iterator = allUsers.iterator();
        List<UserDto> listToReturn = new ArrayList<>();


        while (iterator.hasNext()) {
            UserEntity userEntity = iterator.next();
            UserDto userDto = modelMapper.map(userEntity, UserDto.class);
            listToReturn.add(userDto);
        }


        return listToReturn;
    }
   // @Secured("ADMIN")
    public void deleteUser(UserDto userDto){
        UserEntity userEntity=modelMapper.map(userDto,UserEntity.class);
        userRepository.delete(userEntity);
    }
    public void save(UserDto userToSave){
        UserEntity entityToSave = modelMapper.map(userToSave, UserEntity.class);
        userRepository.save(entityToSave);
    }
}

