package Evizinhotest2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Evizinhotest2.model.Client;
import Evizinhotest2.service.ClientService;

@Controller
public class ClientController {
	@Autowired
	private ClientService clientService;

	 @RequestMapping(value = "/clients")
	  public List<Client> getAllUsers(Model model) 
	  {		
		 List<Client> clients = clientService.getAllUsers();
		 model.addAttribute("clients", clients);
		 return clients;
	  }	
	 
	 
	 @RequestMapping(value = "/clients/{id}")
	 public Optional<Client> getUser(@PathVariable Integer id) {
	 	return clientService.getUser(id);
	 }
	 
	 
	 @RequestMapping(value = "/clients", method = RequestMethod.POST)
	 public void addUser(@RequestBody Client user) {
		 clientService.addUser(user);
	 }
	 
	 @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
	 public void updateUser(@RequestBody Client user,@PathVariable Integer id ) {
		 clientService.updateUser(id, user);
	 }
	 
	 @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
	 public void deleteUser(@PathVariable Integer id) {
		 clientService.deleteUser(id);
		 	 
	 }

}
