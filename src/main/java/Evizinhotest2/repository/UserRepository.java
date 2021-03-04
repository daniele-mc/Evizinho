package Evizinhotest2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Evizinhotest2.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
