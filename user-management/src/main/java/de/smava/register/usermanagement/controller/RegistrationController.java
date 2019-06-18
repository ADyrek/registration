package de.smava.register.usermanagement.controller;

import de.smava.register.usermanagement.domain.dto.UserDto;
import de.smava.register.usermanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/register")
    public Long register(@RequestBody UserDto userDto) {

        return userService.register(userDto);
    }

    @GetMapping("/findUser/{email}")
    public UserDto findUser(@PathVariable("email") String email) {

        return userService.findUser(email);
    }

}
