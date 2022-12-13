package com.revature.yolp.services;

import com.revature.yolp.dtos.requests.NewLoginRequest;
import com.revature.yolp.dtos.requests.NewUserRequest;
import com.revature.yolp.dtos.responses.Principal;
import com.revature.yolp.entities.User;
import com.revature.yolp.repositories.UserRepository;
import com.revature.yolp.utils.custom_exceptions.InvalidAuthException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/* purpose of UserService is to validate and retrieve data from the DAO (DATA ACCESS OBJECT) */
/* Service class is essentially an api */
@Service
public class UserService {
    /* dependency injection = when a class is dependent on another class */
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User signup(NewUserRequest req) {
        User createdUser = new User(UUID.randomUUID().toString(), req.getUsername(), req.getPassword1(), "DEFAULT");
        userRepo.save(createdUser);
        return createdUser;
    }

    public Principal login(NewLoginRequest req) {
        User validUser = userRepo.findByUsernameAndPassword(req.getUsername(), req.getPassword());
        if (validUser == null) throw new InvalidAuthException("Invalid username or password");
        return new Principal(validUser.getId(), validUser.getUsername(), validUser.getRole());
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    // can throw sql exception
    public List<User> getAllUsersByUsername(String username) {
        return userRepo.findAllByUsername(username);
    }

    public boolean isValidUsername(String username) {
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }

    public boolean isDuplicateUsername(String username) {
        List<String> usernames = userRepo.findAllUsernames(username);
        return usernames.contains(username);
    }

    public boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }

    public boolean isSamePassword(String password1, String password2) {
        return password1.equals(password2);
    }
}
