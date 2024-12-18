package pp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pp.model.User;
import pp.service.UserService;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "allUsers";
    }

    @GetMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }
    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.persist(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user")
    public String editUser(@RequestParam ("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "editUser";
    }

    @PostMapping("/user")
    public String updateUser(@ModelAttribute("user") User user,@RequestParam ("id") long id) {
        userService.update(user,id);
        return "redirect:/";
    }








}
