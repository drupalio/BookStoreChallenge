package co.ximple.challenge.repository;

import co.ximple.challenge.repository.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailAndPassword(String email, String password);
}
