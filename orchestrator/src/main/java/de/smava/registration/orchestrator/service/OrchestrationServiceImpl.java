package de.smava.registration.orchestrator.service;

import de.smava.registration.orchestrator.domain.RegistrationResult;
import de.smava.registration.orchestrator.domain.UserLoanDetails;
import de.smava.registration.orchestrator.domain.common.LoanApplicationDto;
import de.smava.registration.orchestrator.domain.common.PersonDto;
import de.smava.registration.orchestrator.domain.common.RegistrationFormDto;
import de.smava.registration.orchestrator.domain.common.UserDto;
import de.smava.registration.orchestrator.integration.loanService.LoanApplicationServiceClient;
import de.smava.registration.orchestrator.integration.personService.PersonServiceClient;
import de.smava.registration.orchestrator.integration.userService.UserServiceClient;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Data
@Slf4j
public class OrchestrationServiceImpl implements OrchestrationService {

    private final UserServiceClient userServiceClient;
    private final PersonServiceClient personServiceClient;
    private final LoanApplicationServiceClient loanApplicationServiceClient;

    @Override
    public UserLoanDetails getUserLoans(Long userId) {

        try {
            return UserLoanDetails.builder()
                    .person(personServiceClient.retrievePersonDetails(userId))
                    .loans(loanApplicationServiceClient.retrieveLoanApplications(userId))
                    .build();

        } catch (Exception ex) {
            log.error("Failed call: {}", ex.getMessage()); //TODO: throw own exception + Controller advice
            return null;
        }
    }

    @Override
    public RegistrationResult processRegistration(RegistrationFormDto registrationFormDto) {

        try {
            Long userId = userServiceClient.registerUser(registrationFormDto.getUser());

            LoanApplicationDto loanApplication = registrationFormDto.getLoanApplication();
            loanApplication.setOwnerId(userId);
            loanApplicationServiceClient.saveLoanApplication(loanApplication);

            PersonDto personDto = registrationFormDto.getPerson();
            personDto.setUserId(userId);
            personServiceClient.savePersonDetails(personDto);

        } catch (Exception ex) {
            log.error("Failed call: {}", ex.getMessage());
            return RegistrationResult.builder().success(false).build();
        }

        return RegistrationResult.builder().success(true).build();
    }

    @Override
    public UserDto findUser(String email) {

        UserDto user = null;
        try {
            user = userServiceClient.findUser(email);
        } catch (Exception ex) {
            log.error("Failed call: {}", ex.getMessage());
        }

        return user;
    }

    @Override
    public Object getToken() {
        return null;
    }
}
