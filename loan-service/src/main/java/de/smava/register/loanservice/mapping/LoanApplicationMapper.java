package de.smava.register.loanservice.mapping;

import de.smava.register.loanservice.domain.dto.LoanApplicationDto;
import de.smava.register.loanservice.domain.entity.LoanApplicationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface LoanApplicationMapper {

    LoanApplicationMapper INSTANCE = Mappers.getMapper(LoanApplicationMapper.class);

    LoanApplicationEntity loanApplicationDtoToLoanApplicationEntity(LoanApplicationDto loanApplicationDto);
    LoanApplicationDto loanApplicationEntityToLoanApplicationDto(LoanApplicationEntity loanApplicationEntity);

}
