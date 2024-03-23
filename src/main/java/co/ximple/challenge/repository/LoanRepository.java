package co.ximple.challenge.repository;

import co.ximple.challenge.repository.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Long> { }
