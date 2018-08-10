package org.dxy.websafedemo.controller;

import org.dxy.websafedemo.domain.User;
import org.dxy.websafedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/xss")
public class XssController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping
    public String exec(Model model) {
        List<User> users = userRepository.findAll();
        if (users.size() > 0) {
            model.addAttribute("name", users.get(users.size()-1).getName());
        }
        return "xss/index.html";
    }

    @RequestMapping(value = "/search")
    public String search(String searchKey, Model model) {
        model.addAttribute("searchKey", searchKey);
        return "xss/index";
    }

    @RequestMapping(value = "/save")
    public String submit(String name, Model model) {
        User user = userRepository.save(User.of().setName(name));
        model.addAttribute("user", user);
        return "xss/index";
    }

}
