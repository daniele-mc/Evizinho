package Evizinhotest2.controller;

import Evizinhotest2.model.User;
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
    public String login(User user, Model model) {
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(User user, Model model) {
        model.addAttribute("user", user);
        if (loginService.getUserEmail(user.getEmail()).isEmpty()) {
            return "login";
        }
        else {
            return "home";
        }
    }
}
