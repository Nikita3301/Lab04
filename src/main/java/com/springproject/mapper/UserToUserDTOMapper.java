package com.springproject.mapper;

import com.springproject.dto.UserDTO;
import com.springproject.entity.Check;
import com.springproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class UserToUserDTOMapper {
    @Autowired
    private CheckToCheckDTOMapper checkToCheckDTOMapper;


    public User toEntity(final UserDTO userDTO, final List<Check> checkList) {
        final User user = new User();

        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setBirth(userDTO.getBirth());
        user.setHeight(userDTO.getHeight());
        user.setWeight(userDTO.getWeight());
        user.setChecks(checkList);

        return user;
    }

    public UserDTO toDTO(final User user) {
        final UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setBirth(user.getBirth());
        userDTO.setHeight(user.getHeight());
        userDTO.setWeight(user.getWeight());
        if (user.getChecks() != null) {
            userDTO.setChecksDTO(user.getChecks().stream().map(check -> checkToCheckDTOMapper.toDTO(check)).collect(Collectors.toList()));
        }
        else{
            userDTO.setChecksDTO(null);
        }


        return userDTO;
    }
}
