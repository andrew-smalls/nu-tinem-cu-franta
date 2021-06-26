package nuTinemCuFranta.plai.controllers;

import nuTinemCuFranta.plai.model.Organization;
import nuTinemCuFranta.plai.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import nuTinemCuFranta.plai.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

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
            @ModelAttribute("organization") Organization organization
    ) {

        // CKeditor adds paragraph tags around description and must be deleted
        String truncDesc = organization.getDescription();
        truncDesc = truncDesc.substring(3, truncDesc.length() - 6);
        organization.setDescription(truncDesc);
        //organization.setId(organizationId);
        organizationService.addOrganization(organization);
        return "redirect:/login";
    }

    @PostMapping("/deleteOrganization")
    public String deleteOrganization(@RequestParam("orgId") Long id) {
        organizationService.deleteOrganization(id);
        return "redirect:home_page_admin";
    }
}