package nuTinemCuFranta.plai.controllers;

import nuTinemCuFranta.plai.model.User;
import nuTinemCuFranta.plai.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@EnableWebSecurity
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/loginUser")
    public String getRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "loginUser";
    }

    /* @PostMapping("/loginUser")
    public String proccesLogin( User user){
        return "redirect:/home_page_admin";
    }
     */

    @RequestMapping("/register")
    public String processRegister(User user ){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);
        return "redirect:/profile_configuration_organization";
    }
}
