package nuTinemCuFranta.plai.services;

import nuTinemCuFranta.plai.model.Assignee;
import nuTinemCuFranta.plai.model.Task;
import nuTinemCuFranta.plai.repositories.AssigneeRepository;
import nuTinemCuFranta.plai.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssigneeService {

    @Autowired
    private AssigneeRepository assigneeRepository;

    public void addAssignee(Assignee assignee){
        assigneeRepository.save(assignee);
    }

    public Assignee getAssigneeById(Long id){
        return assigneeRepository.findById(id).get();
    }

    public List<Assignee> getAllAssignees(){
        return (List<Assignee>) assigneeRepository.findAll();
    }

    public void deleteAssigneeById(Long id)
    {
        assigneeRepository.deleteById(id);
    }
}
