package de.smava.register.loanservice.controller;

import de.smava.register.loanservice.domain.dto.LoanApplicationDto;
import de.smava.register.loanservice.domain.dto.LoanApplicationResponse;
import de.smava.register.loanservice.service.LoanApplicationService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/")
public class LoanController {

    private final LoanApplicationService loanApplicationService;

    @GetMapping("/loanApplications/{userId}")
    public List<LoanApplicationDto> retrieveLoans(@PathVariable("userId") Long userId) {

        return loanApplicationService.retrieveLoanApplications(userId);
    }


    @PostMapping("/loanApplications")
    public LoanApplicationResponse saveUserDetails(@RequestBody LoanApplicationDto loanApplicationDto) {

        return LoanApplicationResponse
                .builder()
                .success(loanApplicationService.saveLoanApplication(loanApplicationDto))
                .build();
    }

}
