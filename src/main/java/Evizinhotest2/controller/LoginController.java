package Evizinhotest2.controller;

import Evizinhotest2.model.Client;
import Evizinhotest2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Client client, Model model) {
        model.addAttribute("client", client);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(Client client, Model model) {
        model.addAttribute("client", client);
        if (loginService.getUserEmail(client.getEmail()).isEmpty()) {
            return "login";
        }
        else {
            return "home";
        }
    }
}
