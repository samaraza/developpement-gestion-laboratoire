package com.example.gestionlabo.controller;


import com.example.gestionlabo.model.Role;
import com.example.gestionlabo.model.User;
import com.example.gestionlabo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController{
        @Autowired
        private UserService userService;

        @GetMapping
        public List<User> getAllUsers() {

            return userService.getAllUsers();
        }

        @GetMapping("/{id}")
        public User getUserById(@PathVariable String id) {

            return userService.findById(id);
        }

        @GetMapping("/email/{email}")
        public User getUserByEmail(@PathVariable String email) {

            return userService.findByEmail(email);
        }
    @PostMapping
    public User createUser(@RequestBody Map<String, Object> payload) {
        String firstName = (String) payload.get("firstName");
        String lastName = (String) payload.get("lastName");
        String email = (String) payload.get("email");
        String password = (String) payload.get("password");
        Role role = Role.valueOf((String) payload.get("role"));

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody Map<String, Object> payload) {
        String firstName = (String) payload.get("firstName");
        String lastName = (String) payload.get("lastName");
        String password = (String) payload.get("password");
        String email = (String) payload.get("email");

        User user = userService.findById(id);
        if (firstName != null) {
            user.setFirstName(firstName);
        }
        if (lastName != null) {
            user.setLastName(lastName);
        }
        if (password != null && !password.isEmpty()) {
            user.setPassword(password);
        }

        if (email != null && !email.isEmpty()) {
            user.setEmail(email);
        }

        return userService.save(user);
    }

    @PutMapping("/admin/{id}")
    public User updateFromAdmin(@PathVariable String id, @RequestBody Map<String, Object> payload) {
        String firstName = (String) payload.get("firstName");
        String lastName = (String) payload.get("lastName");
        String email = (String) payload.get("email");
        String roleString = (String) payload.get("role");

        User user = userService.findById(id);
        if (firstName != null) {
            user.setFirstName(firstName);
        }
        if (lastName != null) {
            user.setLastName(lastName);
        }

        if (roleString != null) {
            user.setRole(Role.valueOf(roleString));
        }

        if (email != null && !email.isEmpty()) {
            user.setEmail(email);
        }

        return userService.saveFromAdmin(user);
    }

         @DeleteMapping("/{id}")
         public void deleteUser(@PathVariable String id) {
            userService.deleteById(id);
    }
}
