package peaksoft.sessionjava17restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.sessionjava17restapi.entities.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findUserByEmail(String email);

    boolean existsByEmail(String email);
}
