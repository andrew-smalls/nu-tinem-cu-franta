package nuTinemCuFranta.plai.controllers;

import nuTinemCuFranta.plai.model.Project;
import nuTinemCuFranta.plai.model.User;
import nuTinemCuFranta.plai.services.ProjectService;
import nuTinemCuFranta.plai.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/addProject")
    private String addUser(@RequestParam("projectName") String projectName,
                           @RequestParam("organizationName") String organizationName,
                           @RequestParam("projectCoordinator") String projectCoordinator

                           ){
        Project project = new Project(projectName, organizationName, projectCoordinator);
        projectService.addProject(project);

        return "redirect:/projects";
    }

    @RequestMapping("/projects")
    private String projectPage(Model model){

        List<Project> projects = projectService.getProjects();
        model.addAttribute("projects", projects);

        return "projects";
    }

}
