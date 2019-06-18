package de.smava.registration.orchestrator.integration.userService;

import de.smava.registration.orchestrator.domain.common.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="user-management" )
public interface UserServiceClient {

    @PostMapping("/register")
    Long registerUser(@RequestBody UserDto userDto);

    @GetMapping("/findUser/{email}")
    UserDto findUser(@PathVariable("email") String email);
}
