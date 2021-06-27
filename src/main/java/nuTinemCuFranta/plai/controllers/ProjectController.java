package nuTinemCuFranta.plai.controllers;

import nuTinemCuFranta.plai.model.Project;
import nuTinemCuFranta.plai.services.OrganizationService;
import nuTinemCuFranta.plai.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import nuTinemCuFranta.plai.model.Organization;
import nuTinemCuFranta.plai.model.Project;
import nuTinemCuFranta.plai.model.User;
import nuTinemCuFranta.plai.services.OrganizationService;
import nuTinemCuFranta.plai.services.ProjectService;
import nuTinemCuFranta.plai.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private OrganizationService organizationService;


    @PostMapping("/addProject")
    private String addProject(@RequestParam("projectName") String projectName,
                              @RequestParam("projectCoordinator") String projectCoordinator,
                              @RequestParam("projectDescription") String projectDescription,
                              @RequestParam("organizationId") Long organizationId
    ){
                           @RequestParam("projectCoordinator") String projectCoordinator,
                           @RequestParam("projectDescription") String projectDescription,
                           @RequestParam("organizationId") Long organizationId
                           ){


        Project project = new Project(projectName, projectCoordinator, projectDescription);
        project.setOrganizationId(organizationId);
        projectService.addProject(project);

        return "redirect:/" + organizationId + "/projects";
    }

    @RequestMapping("{organizationId}/projects") // example: /3/projects -> 3rd organization registered projects
    private String projectPage(Model model, @PathVariable("organizationId") Long organizationId){

        model.addAttribute("organizationId", organizationId);

        List<Project> projects = projectService.getProjects();
        model.addAttribute("projects", projects);

        return "projects";
    }


    @PostMapping("/deleteProject")
    public String deleteProject(@RequestParam("projectId") Long id) {
        projectService.deleteProject(id);
        return "redirect:projects";
    }

    @RequestMapping("/{organizationId}/{projectName}")
    public String visitSpecificProjectPage(Model model,
                                           @PathVariable("organizationId") Long organizationId,
                                           @PathVariable("projectName") String projectName){

        System.out.println("Proj name is " + projectName);

        model.addAttribute("organizationId", organizationId);
        model.addAttribute("projectName", projectName);

        Project project = projectService.getProjectByName(projectName);

        System.out.println("Project is " + project);

        return "project_page_organization"; // /" +project.getId();
    }

    }
}
