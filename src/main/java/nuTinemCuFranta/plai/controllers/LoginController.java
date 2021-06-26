package nuTinemCuFranta.plai.controllers;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import nuTinemCuFranta.plai.model.User;
import nuTinemCuFranta.plai.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepo;
    
    @RequestMapping("/login")
    public String getIndexPage(){
        return "/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    // Hash for password
    @PostMapping("/home_page_admin")
    public String processRegister(User user) {

        /* Argon2 Implementation  */
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
        String encodedPassword = argon2.hash(4, 1024 * 1024, 8, user.getPassword());
        /* Argon2 Implementation  */

        user.setPassword(encodedPassword);
        userRepo.save(user);

        return "register_success";
    }

}
