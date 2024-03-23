package co.ximple.challenge.mappers;

import co.ximple.challenge.repository.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> { }
