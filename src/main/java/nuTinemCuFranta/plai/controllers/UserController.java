package nuTinemCuFranta.plai.controllers;

import nuTinemCuFranta.plai.model.User;
import nuTinemCuFranta.plai.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    private String addUser(@RequestParam("email") String email,
                           @RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("password") String password,
                           @RequestParam("role") String role
                           ){
        User user=new User(firstName,lastName,email,password,role);
        userService.addUser(user);

        return "/index";
    }

}
