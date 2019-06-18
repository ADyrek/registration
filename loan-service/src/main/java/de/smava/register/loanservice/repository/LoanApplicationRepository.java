package de.smava.register.loanservice.repository;

import de.smava.register.loanservice.domain.entity.LoanApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanApplicationRepository extends JpaRepository<LoanApplicationEntity, Long> {

    List<LoanApplicationEntity> findByOwnerId(Long userId);
}
