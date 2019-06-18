package de.smava.register.authorization.integration;

import de.smava.register.authorization.domain.common.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="orchestrator" )
public interface OrchestratorClient {

    @GetMapping("/findUser/{email}")
    UserDto findUser(@PathVariable("email") String email);

}
