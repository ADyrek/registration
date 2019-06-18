package de.smava.registration.orchestrator.integration.personService;

import de.smava.registration.orchestrator.domain.RegistrationResult;
import de.smava.registration.orchestrator.domain.common.PersonDto;
import de.smava.registration.orchestrator.domain.common.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="person-details" )
public interface PersonServiceClient {

    @PostMapping("/personDetails")
    RegistrationResult savePersonDetails(@RequestBody PersonDto personDto);

    @GetMapping("/personDetails/{userId}")
    PersonDto retrievePersonDetails(@PathVariable("userId") Long userId);

}
