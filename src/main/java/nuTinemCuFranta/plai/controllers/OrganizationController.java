package nuTinemCuFranta.plai.controllers;

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

    @PostMapping("/deleteOrganization")
    public String deleteOrganization(@RequestParam("orgId") Long id){
        organizationService.deleteOrganization(id);
        return "redirect:home_page_admin";
    }

}
