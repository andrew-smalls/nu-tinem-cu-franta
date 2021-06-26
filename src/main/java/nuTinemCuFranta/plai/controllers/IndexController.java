package nuTinemCuFranta.plai.controllers;

import nuTinemCuFranta.plai.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String getIndexPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("/loginUser.html")
    public String getLoginUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "loginUser";
    }

}
