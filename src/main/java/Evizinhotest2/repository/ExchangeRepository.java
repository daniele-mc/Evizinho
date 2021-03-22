package Evizinhotest2.repository;

import Evizinhotest2.model.Exchange;
import Evizinhotest2.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {
    public List<Exchange> findByUserId(Integer userId);

}
