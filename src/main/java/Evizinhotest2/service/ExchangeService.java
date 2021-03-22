package Evizinhotest2.service;

import Evizinhotest2.model.Exchange;
import Evizinhotest2.model.Post;
import Evizinhotest2.repository.ExchangeRepository;
import Evizinhotest2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ExchangeService {
    @Autowired
    public ExchangeRepository exchangeRepository;

    public List<Exchange> getAllExchanges() {

        List<Exchange> exchanges = new ArrayList<>();

        exchangeRepository.findAll()
                .forEach(exchanges::add);

        return exchanges;
    }

    @Transactional(readOnly = false)
    public void addExchange(Exchange exchange) {
        exchangeRepository.save(exchange);
    }

    public Optional<Exchange> getExchange(Integer id) {
        return exchangeRepository.findById(id);
    }

    @Transactional(readOnly = false)
    public void updateExchange(Integer id, Exchange post) {
        exchangeRepository.save(post);
    }

    @Transactional(readOnly = false)
    public void deleteExchange(Integer id) {
        exchangeRepository.deleteById(id);
    }

    public List<Exchange> getExchangesByUser(Integer id) {
        List<Exchange> exchanges = new ArrayList<>();

        exchangeRepository.findByUserId(id)
                .forEach(exchanges::add);

        return exchanges;
    }

}
