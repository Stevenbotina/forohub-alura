package com.alura.forohub.controller;

import com.alura.forohub.domain.topic.user.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping
    @Transactional
    public ResponseEntity<UserResponseData> registerUser(@RequestBody @Valid RegisterUserData data) {
        String encodedPassword = passwordEncoder.encode(data.password());
        var newUser = new User(data.name(), data.email(), encodedPassword);
        userRepository.save(newUser);

        var response = new UserResponseData(newUser);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseData>> listUsers(@PageableDefault(size = 4) Pageable pagination) {
        return ResponseEntity.ok(userRepository.findAll(pagination).map(UserResponseData::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseData> getUser(@PathVariable Long id) {
        User user = userRepository.getReferenceById(id);

        var response = new UserResponseData(user);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UserResponseData> updateUser(@RequestBody @Valid UpdateUserData updatedUser) {
        User user = userRepository.getReferenceById(updatedUser.id());

        String encodedPassword = null;
        if (updatedUser.password() != null) {
            encodedPassword = passwordEncoder.encode(updatedUser.password());
        }
        user.updateData(updatedUser.name(), encodedPassword);

        var response = new UserResponseData(user);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

