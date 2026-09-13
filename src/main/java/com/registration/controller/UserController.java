package com.registration.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.dto.UserResponse;
import com.registration.entity.User;
import com.registration.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://registration-frontend.vercel.app"
})
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register
    @PostMapping("/register")
    public UserResponse registerUser(@RequestBody User user) {

        User savedUser = userService.registerUser(user);

        return convertToResponse(savedUser);
    }

    // Get all users
    @GetMapping
    public List<UserResponse> getAllUsers() {

        return userService.getAllUsers()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public UserResponse getUserById(
            @PathVariable Long id) {

        User user = userService.getUserById(id);

        return convertToResponse(user);
    }

    // Update
    @PutMapping("/{id}")
    public UserResponse updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        User updatedUser =
                userService.updateUser(id, user);

        return convertToResponse(updatedUser);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteUser(
            @PathVariable Long id) {

        return userService.deleteUser(id);
    }

    // Convert Entity → DTO
    private UserResponse convertToResponse(User user) {

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getDateOfBirth(),
                user.getGender(),
                user.getAddress()
        );
    }
}