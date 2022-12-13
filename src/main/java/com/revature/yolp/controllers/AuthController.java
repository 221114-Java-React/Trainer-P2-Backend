package com.revature.yolp.controllers;

import com.revature.yolp.dtos.requests.NewLoginRequest;
import com.revature.yolp.dtos.responses.Principal;
import com.revature.yolp.services.TokenService;
import com.revature.yolp.services.UserService;
import com.revature.yolp.utils.custom_exceptions.InvalidAuthException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final TokenService tokenService;

    public AuthController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping
    public Principal login(@RequestBody NewLoginRequest req) {
        Principal principal = userService.login(req);
        String token = tokenService.generateToken(principal);
        principal.setToken(token);
        return principal;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(InvalidAuthException.class)
    public InvalidAuthException handledAuthException (InvalidAuthException e) {
        return e;
    }
}
