package com.springproject.service.impl;

import com.springproject.dto.UserDTO;
import com.springproject.exception.ServiceException;
import com.springproject.mapper.UserToUserDTOMapper;
import com.springproject.repository.UserRepository;
import com.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserToUserDTOMapper userMapper;


    @Override
    public UserDTO getUserById(final Long id) {
        return userMapper.toDTO(userRepository.getUserById(id));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(e -> userMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(final UserDTO userDTO) {
        if(userDTO.getId() != null){
            throw new ServiceException(400, "User shouldn't have an id ", null);
        }

        return userMapper.toDTO(userRepository.createUser(userMapper.toEntity(userDTO, null)));
    }

    @Override
    public UserDTO updateUser(final UserDTO userDTO) {
        if(userDTO.getId() == null){
            throw new ServiceException(400, "User must have an id ", null);
        }

        if(userRepository.getUserById(userDTO.getId()).getChecks() == null) {
            return userMapper.toDTO(userRepository.updateUser(userMapper.toEntity(userDTO, null)));
        } else {
            return userMapper.toDTO(userRepository.updateUser(userMapper.toEntity(userDTO, userRepository.getUserById(userDTO.getId()).getChecks())));
        }
    }

    @Override
    public void deleteUserById(final Long id) {
        userRepository.deleteUserById(id);
    }
}
