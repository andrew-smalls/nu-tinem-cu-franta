package nuTinemCuFranta.plai.controllers;

import nuTinemCuFranta.plai.model.Organization;
import nuTinemCuFranta.plai.model.Photo;
import nuTinemCuFranta.plai.model.Project;
import nuTinemCuFranta.plai.services.OrganizationService;
import nuTinemCuFranta.plai.services.PhotoService;
import nuTinemCuFranta.plai.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/profile_configuration_organization")
    public String getProfileConfiguration(Model model) {
        Organization organization = new Organization();
        //model.addAttribute("organizationId",organizationId);
        model.addAttribute("organization", organization);
        return "profile_configuration_organization";
    }

    @PostMapping("/process_profile_organization")
    public String addOrganization(
            //@RequestParam("organizationId") Long organizationId,
            @RequestParam("profile_picture")MultipartFile photo,
            @ModelAttribute("organization") Organization organization
    ) {

        Long userId=Long.valueOf(3); // TODO this should be removed when working with real ids

        // CKeditor adds paragraph tags around description and must be deleted
        String truncDesc = organization.getDescription();
        truncDesc = truncDesc.substring(3, truncDesc.length() - 6);
        organization.setDescription(truncDesc);
        organization.setId(userId); // hardcoded
        organization.setName("numeHardcodat");
        organizationService.addOrganization(organization);
        photoService.savePhoto(photo,userId,true);
        return "redirect:/home_page_admin";
    }

    @PostMapping("/deleteOrganization")
    public String deleteOrganization(@RequestParam("orgId") Long id) {
        organizationService.deleteOrganization(id);
        return "redirect:home_page_admin";
    }

    @RequestMapping("/home_page_organization/{orgId}")
    public String getOrganizationHomePage(@PathVariable("orgId") Long orgId, Model model) {
        Organization organization = organizationService.getOrganization(orgId);

        model.addAttribute("organizationId", orgId);

        Photo profilePhoto=photoService.getProfilePhoto(orgId);
        if(profilePhoto==null){
            profilePhoto=new Photo();
        }

        List<Project> projects=projectService.getOrganizationProjects(orgId);
        model.addAttribute("projects",projects);
        model.addAttribute("profilePhoto",profilePhoto);
        model.addAttribute("organization", organization);
        return "/home_page_organization";
    }

    @RequestMapping("/organization_photos/{orgId}")
    public String getOrganizationPhotosGuests(@PathVariable("orgId") Long orgId,Model model) {

        List<Photo> photos=photoService.getPhotos(orgId);
        Photo profilePhoto = photoService.getProfilePhoto(orgId);
        if(profilePhoto==null){
            profilePhoto=new Photo();
        }
        model.addAttribute("profilePhoto",profilePhoto);
        model.addAttribute("photos",photos);
        model.addAttribute("organization", orgId);
        return "organization_photos";
    }


}