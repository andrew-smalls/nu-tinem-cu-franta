package nuTinemCuFranta.plai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/home_page_admin")
    public String getIndexPage(){
        return "/home_page_admin";
    }
}
