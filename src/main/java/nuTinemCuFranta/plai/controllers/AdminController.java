package nuTinemCuFranta.plai.controllers;

import nuTinemCuFranta.plai.model.Notification;
import nuTinemCuFranta.plai.model.Organization;
import nuTinemCuFranta.plai.services.NotificationService;
import nuTinemCuFranta.plai.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/home_page_admin")
    public String getAdminHomePage(Model model){

        List<Organization> organizations=organizationService.getAllOrganizations();
        List<Notification> notifications=notificationService.getAllUserNotifications(Long.valueOf(3));
        model.addAttribute("organizations",organizations);
        model.addAttribute("notifications",notifications);
        model.addAttribute("count",notifications.size());
        return "/home_page_admin";
    }

    @RequestMapping("/organization_details_admin")
    public String getOrganizationDetails(Model model){

        return "/organization_details_admin";
    }

}
