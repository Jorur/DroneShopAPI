package org.dronshopapi.dronshopapi.service.impl;

import org.dronshopapi.dronshopapi.DTO.UserDto;
import org.dronshopapi.dronshopapi.entity.User;
import org.dronshopapi.dronshopapi.exception.ResourceNotFoundException;
import org.dronshopapi.dronshopapi.repository.UserRepository;
import org.dronshopapi.dronshopapi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl (UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        User newUser = userRepository.save(user);

        return mapToDto(newUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id.toString()));
        return mapToDto(user);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new ResourceNotFoundException("User", "username", username);
        }
        return mapToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User", "id", id.toString()));

        existingUser.setFullName(userDto.getFullName());
        existingUser.setUsername(userDto.getUsername());
        existingUser.setMail(userDto.getMail());

        if(userDto.getPassword() != null && !userDto.getPassword().isEmpty())
            existingUser.setPassword(passwordEncoder.encode(userDto.getPassword()));

        existingUser.setGender(userDto.getGender());
        existingUser.setBirthDate(userDto.getBirthDate());
        existingUser.setPhoneNumber(userDto.getPhoneNumber());
        existingUser.setAddress(userDto.getAddress());


        User updatedUser = userRepository.save(existingUser);
        return mapToDto(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)){
            throw new ResourceNotFoundException("Post", "id", id.toString());
        }
        userRepository.deleteById(id);
    }

    private UserDto mapToDto(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFullName(user.getFullName());
        userDto.setUsername(user.getUsername());
        userDto.setMail(user.getMail());
        userDto.setPassword(user.getPassword());
        userDto.setGender(user.getGender());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setAddress(user.getAddress());
        userDto.setRole(user.getRole());

        return userDto;
    }

    private User mapToEntity(UserDto userDto){
        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setUsername(userDto.getUsername());
        user.setMail(userDto.getMail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setGender(userDto.getGender());
        user.setBirthDate(userDto.getBirthDate());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setAddress(userDto.getAddress());
        user.setRole(userDto.getRole());

        return user;
    }
}
