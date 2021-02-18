package Evizinhotest2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Evizinhotest2.model.Client;
import Evizinhotest2.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	public ClientRepository clientRepository;
		
	public List<Client> getAllUsers() {
		
	    List<Client> users = new ArrayList<>();
		
	    clientRepository.findAll()
	    .forEach(users::add);
		
	    return users;		
	}
	
	public void addUser(Client user) {
	     clientRepository.save(user);
	}
	
	public Optional<Client> getUser(Integer id) {
	     return clientRepository.findById(id);
	}
	
	public void updateUser(Integer id, Client user) {
	     clientRepository.save(user);
	}
	
	public void deleteUser(Integer id) {
	     clientRepository.deleteById(id);
	}
}
