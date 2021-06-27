package nuTinemCuFranta.plai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VolunteerController {

    @RequestMapping("/home_page_volunteer")
    public String getVolunteerHomePage(Model model){


        return "/home_page_volunteer";
    }

    @RequestMapping("/profile_volunteer")
    public String getVolunteerProfile(Model model){


        return "/profile_volunteer";
    }

}
