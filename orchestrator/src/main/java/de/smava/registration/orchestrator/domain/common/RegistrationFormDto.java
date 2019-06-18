package de.smava.registration.orchestrator.domain.common;

import lombok.Data;

@Data
public class RegistrationFormDto {

    private UserDto user;
    private PersonDto person;
    private LoanApplicationDto loanApplication;

}
