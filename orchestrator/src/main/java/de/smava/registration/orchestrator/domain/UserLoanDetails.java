package de.smava.registration.orchestrator.domain;

import de.smava.registration.orchestrator.domain.common.LoanApplicationDto;
import de.smava.registration.orchestrator.domain.common.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoanDetails {

    private PersonDto person;
    private List<LoanApplicationDto> loans;

}
