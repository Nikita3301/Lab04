package com.springproject.resource;

import com.springproject.dto.UserDTO;
import com.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;


    @GetMapping("/user/{id}")
    public UserDTO getUserById(final @PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/all_users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create_user")
    public UserDTO createUser(final  @Valid @RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("/update_user")
    public UserDTO getUserById(final @RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/delete_user/{id}")
    public void deleteUserById(final @Valid @PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
