package co.ximple.challenge.repository;

import co.ximple.challenge.repository.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book,Long> { }
