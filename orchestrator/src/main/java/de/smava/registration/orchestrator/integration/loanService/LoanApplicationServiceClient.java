package de.smava.registration.orchestrator.integration.loanService;

import de.smava.registration.orchestrator.domain.RegistrationResult;
import de.smava.registration.orchestrator.domain.common.LoanApplicationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="loan-service" )
public interface LoanApplicationServiceClient {

    @PostMapping("/loanApplications")
    RegistrationResult saveLoanApplication(@RequestBody LoanApplicationDto loanApplicationDto);

    @GetMapping("/loanApplications/{userId}")
    List<LoanApplicationDto> retrieveLoanApplications(@PathVariable("userId") Long userId);

}
