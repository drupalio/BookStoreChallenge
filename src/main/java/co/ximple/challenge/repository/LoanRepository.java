package co.ximple.challenge.repository;

import co.ximple.challenge.repository.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> { }
