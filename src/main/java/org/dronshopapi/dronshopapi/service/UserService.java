package org.dronshopapi.dronshopapi.service;

import org.dronshopapi.dronshopapi.DTO.UserDto;
import org.dronshopapi.dronshopapi.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto, Long id);
    void deletePostById(Long id);
}
