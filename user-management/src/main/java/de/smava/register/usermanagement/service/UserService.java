package de.smava.register.usermanagement.service;

import de.smava.register.usermanagement.domain.dto.UserDto;

public interface UserService {

    Long register(UserDto user);

    UserDto findUser(String email);
}
