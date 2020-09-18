package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Qualifier("userServiceImpl")
    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String allUsers(ModelMap model, @RequestParam(value = "locale", required = false,
            defaultValue = "en")String locale)  {
        List<User> users = userService.allUsers();
        String title = "";
        if(locale.equals("en")) {
            title = "Users";
        } else title = "Юзеры";
        model.addAttribute("title", title);
        model.addAttribute("users", users);
        return "userTable";
    }


    @GetMapping("/add")
    public String showSignUpForm(User user, ModelMap model) {
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/add")
    public String addUser(User user, ModelMap  model) {
        userService.add(user);
        model.addAttribute("users", userService.allUsers());
        return "redirect:/";
    }



    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") int id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, User user, ModelMap  model) {
        user.setId(id);
        userService.edit(user);
        model.addAttribute("users",userService.allUsers());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, ModelMap  model) {
        userService.delete(id);
        model.addAttribute("users", userService.allUsers());
        return "redirect:/";
    }

}