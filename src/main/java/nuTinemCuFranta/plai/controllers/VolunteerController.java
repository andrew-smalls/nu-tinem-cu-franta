package nuTinemCuFranta.plai.controllers;

import nuTinemCuFranta.plai.model.Notification;
import nuTinemCuFranta.plai.model.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VolunteerController {

    @RequestMapping("/home_page_volunteer")
    public String getVolunteerHomePage(Model model){


        return "/home_page_volunteer";
    }
}
