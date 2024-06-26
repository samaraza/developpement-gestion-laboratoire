package com.example.gestionlabo.service;

import com.example.gestionlabo.model.User;
import com.example.gestionlabo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByEmail(String email) {

        return userRepository.findByEmail(email);
    }
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User findById(String id) {

        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    public User saveFromAdmin(User user) {

        return userRepository.save(user);
    }

    public void deleteById(String id) {

        userRepository.deleteById(id);
    }
}
