package Evizinhotest2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Evizinhotest2.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
