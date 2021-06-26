package nuTinemCuFranta.plai.controllers;

import nuTinemCuFranta.plai.model.Notification;
import nuTinemCuFranta.plai.model.Organization;
import nuTinemCuFranta.plai.model.Photo;
import nuTinemCuFranta.plai.services.MailerService;
import nuTinemCuFranta.plai.services.NotificationService;
import nuTinemCuFranta.plai.services.OrganizationService;
import nuTinemCuFranta.plai.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private MailerService mailerService;

    @RequestMapping("/home_page_admin")
    public String getAdminHomePage(Model model){

        List<Organization> organizations=organizationService.getAllOrganizations();
        List<Notification> notifications=notificationService.getAllUserNotifications(Long.valueOf(3));
        model.addAttribute("organizations",organizations);
        model.addAttribute("notifications",notifications);
        model.addAttribute("count",notifications.size());
        return "/home_page_admin";
    }

    @PostMapping("/getOrganisationsSearch")
    public String getOrgs(@RequestParam("search") String text){
            return "redirect:home_page_admin/"+text;
    }

    @RequestMapping("/home_page_admin/{text}")
    public String getAdminHomePageSearch(@PathVariable("text") String text, Model model){

        List<Organization> organizations=organizationService.searchOrganizations(text);
        System.out.println(organizations);
        List<Notification> notifications=notificationService.getAllUserNotifications(Long.valueOf(3));
        model.addAttribute("organizations",organizations);
        model.addAttribute("notifications",notifications);
        model.addAttribute("count",notifications.size());
        model.addAttribute("text",text);
        return "/home_page_admin";
    }


    @RequestMapping("/organization_details_admin/{orgId}")
    public String getOrganizationDetails(@PathVariable("orgId") Long orgId,Model model){
        model.addAttribute("orgId",orgId);
        Photo profilePhoto=photoService.getProfilePhoto(orgId);
        if(profilePhoto==null){
            profilePhoto=new Photo();
        }
        model.addAttribute("profilePhoto",profilePhoto);
        model.addAttribute("photos",photoService.getPhotos(orgId));
        model.addAttribute("org",organizationService.getOrganization(orgId));
        return "/organization_details_admin";
    }

    @PostMapping("/acceptOrganisation")
    public String acceptOrganisation(@RequestParam("orgId") Long orgId){
        organizationService.updateOrganisationStatus(orgId,"accepted");
        mailerService.prepareAndSend("caracoancea.timotei@gmail.com", // TODO pune addresa de email a user-ului
                "Organizatia dumneavoastra a fost acceptata. Puteti folosi aplicatia.",
                "plaiApplicationRequest",
                "plaiAssociation@gmail.com"
                );
        return "redirect:/organization_details_admin/"+orgId;
    }

    @PostMapping("/revokeOrganisation")
    public String revokeOrganisation(@RequestParam("orgId") Long orgId){
        organizationService.updateOrganisationStatus(orgId,"revoked");
        mailerService.prepareAndSend("caracoancea.timotei@gmail.com", // TODO pune addresa de email a user-ului
                "Organizatia dumneavoastra nu a fost acceptata. Din pacate nu puteti folosi aplicatia.",
                "plaiApplicationRequest",
                "plaiAssociation@gmail.com"
        );
        return "redirect:/organization_details_admin/"+orgId;
    }
}
