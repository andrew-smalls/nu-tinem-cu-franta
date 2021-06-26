package nuTinemCuFranta.plai.controllers;

import nuTinemCuFranta.plai.model.User;
import nuTinemCuFranta.plai.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepo;


    @RequestMapping("/")
    public String getIndexPage(){
        return "/index";
    }

    @GetMapping(value = "/login.html")
    public ModelAndView handleRequest(){
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "home_page_admin";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = (List<User>) userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

}
