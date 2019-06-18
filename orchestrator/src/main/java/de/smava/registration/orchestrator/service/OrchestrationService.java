package de.smava.registration.orchestrator.service;

import de.smava.registration.orchestrator.domain.RegistrationResult;
import de.smava.registration.orchestrator.domain.UserLoanDetails;
import de.smava.registration.orchestrator.domain.common.RegistrationFormDto;
import de.smava.registration.orchestrator.domain.common.UserDto;

public interface OrchestrationService {

    UserLoanDetails getUserLoans(Long userId);

    Object getToken();

    RegistrationResult processRegistration(RegistrationFormDto registrationFormDto);

    UserDto findUser(String email);
}
