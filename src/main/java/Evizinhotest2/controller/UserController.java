package Evizinhotest2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Evizinhotest2.model.User;
import Evizinhotest2.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	private static final String MSG_SUCESS_ADD = "Usuário cadastrado com Sucesso!";
	private static final String MSG_SUCESS_UPDATE = "Usuário Atualizado com Sucesso!";
	private static final String MSG_SUCESS_DELETE = "Excluído com sucesso!.";
	private static final String MSG_ERROR = "Error.";
	
	@RequestMapping(value = "/users")
	public List<User> getAllUsers(Model model) 
	{		
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return users;
	}	

	 @RequestMapping(value = "/users/{id}")
	 public Optional<User> getUser(@PathVariable Integer id) {
	 	return userService.getUser(id);
	 }

	 @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	 public void updateUser(@RequestBody User user,@PathVariable Integer id ) {
		 userService.updateUser(id, user);
	 }
	 
	 @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.DELETE)
	 public void deleteUser(@PathVariable Integer id) {
		 userService.deleteUser(id);
		 	 
	 }

	 @GetMapping("/users/{id}")
	 public String show(Model model, @PathVariable("id") Integer id) {
		 if (id != null) {
	 		User user = userService.getUser(id).get();
	 		model.addAttribute("user", user);
	 	}
	 	return "showUser";
	 }

	@RequestMapping(value = "/users/form", method=RequestMethod.GET)
	public String register(Model model, RedirectAttributes redirectAttributes) {
		try {
			User user = new User();
			model.addAttribute("user", user);
		}catch (Exception e) {
			System.out.println("Exception:: exception");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}catch (Throwable e) {
			System.out.println("Throwable:: exception");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}
		return "register";
	}

	@RequestMapping(value = "/users/register", method=RequestMethod.POST)
	public String register(User user, RedirectAttributes redirectAttributes) {
		try {
			userService.addUser(user);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_ADD);
		}catch (Exception e) {
			System.out.println("Exception:: exception");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}catch (Throwable e) {
			System.out.println("Throwable:: exception");
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}
		return "home";
	}

}
