package co.ximple.challenge.mappers;

import co.ximple.challenge.models.LoanRecord;
import co.ximple.challenge.repository.entities.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    @Mapping(target = "id", expression = "java(Optional.empty())")
    Loan loanRecordToLoan(LoanRecord loanRecord);

    LoanRecord loanToLoanRecord(Loan loan);
}
