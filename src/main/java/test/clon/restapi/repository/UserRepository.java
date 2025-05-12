package test.clon.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.clon.restapi.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByBinAndEmail(Integer bin, String email);

}

