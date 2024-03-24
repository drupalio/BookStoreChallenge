package co.ximple.challenge.repository;

import co.ximple.challenge.models.LoanRecord;
import co.ximple.challenge.repository.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {

    List<Loan> findAllByUserId(Long idUser);
}
