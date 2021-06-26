package nuTinemCuFranta.plai.services;

import nuTinemCuFranta.plai.model.Project;
import nuTinemCuFranta.plai.model.User;
import nuTinemCuFranta.plai.repositories.ProjectRepository;
import nuTinemCuFranta.plai.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public void addProject(Project project){
        projectRepository.save(project);
    }

    public Project getProjectById(Long id){
        return projectRepository.findById(id).get();
    }

    public List<Project> getProjects(){
        return (List<Project>) projectRepository.findAll();
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
