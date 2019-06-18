package de.smava.register.loanservice.service;

import de.smava.register.loanservice.domain.dto.LoanApplicationDto;
import de.smava.register.loanservice.domain.entity.LoanApplicationEntity;
import de.smava.register.loanservice.mapping.LoanApplicationMapper;
import de.smava.register.loanservice.repository.LoanApplicationRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;
    private final LoanApplicationMapper loanApplicationMapper;

    public List<LoanApplicationDto> retrieveLoanApplications(Long userId) {
        final List<LoanApplicationEntity> loans = loanApplicationRepository.findByOwnerId(userId);

        return loans.stream()
                .map(loanApplicationMapper::loanApplicationEntityToLoanApplicationDto)
                .collect(Collectors.toList());
    }

    public boolean saveLoanApplication(LoanApplicationDto loanApplicationDto) {

        final LoanApplicationEntity entity = loanApplicationMapper.loanApplicationDtoToLoanApplicationEntity(loanApplicationDto);
        return loanApplicationRepository.save(entity) != null;
    }
}
