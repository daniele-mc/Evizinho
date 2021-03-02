package Evizinhotest2.service;

import Evizinhotest2.model.Client;
import Evizinhotest2.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Evizinhotest2.repository.LoginRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    public LoginRepository loginRepository;

    public Optional<Client> getUserEmail(String email) {
        return loginRepository.findClientByEmail(email);
    }
}
