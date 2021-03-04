package Evizinhotest2.repository;

import Evizinhotest2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<User, String> {
    Optional<User> findUserByEmail(String email);
}
