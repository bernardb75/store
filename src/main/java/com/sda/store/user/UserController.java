package com.sda.store.user;

import com.sda.store.commons.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public String getAllUsers(Model model){
        List<UserDto>allUsers=userService.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        return "userList";
    }
    //@PostMapping

}
