package de.smava.registration.orchestrator.controller;

import de.smava.registration.orchestrator.domain.RegistrationResult;
import de.smava.registration.orchestrator.domain.UserLoanDetails;
import de.smava.registration.orchestrator.domain.common.RegistrationFormDto;
import de.smava.registration.orchestrator.domain.common.UserDto;
import de.smava.registration.orchestrator.service.OrchestrationService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("/")
public class OrchestratorController {

    private final OrchestrationService orchestrationService;

    @PostMapping("/register")
    public RegistrationResult register(@RequestBody RegistrationFormDto registrationFormDto) {

        return orchestrationService.processRegistration(registrationFormDto);
    }

    @GetMapping("/loans/{userId}")
    public UserLoanDetails loanDetails(@PathVariable("userId") Long userId) {

        return orchestrationService.getUserLoans(userId);
    }

    @GetMapping("/findUser/{email}")
    public UserDto findUser(@PathVariable("email") String email) {

        return orchestrationService.findUser(email);
    }

    @PostMapping("/oauth/token")
    public Object getToken() {

        return orchestrationService.getToken();
    }



}
