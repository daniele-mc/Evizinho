package Evizinhotest2.repository;

import Evizinhotest2.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Client, String> {
    Optional<Client> findClientByEmail(String email);
}
