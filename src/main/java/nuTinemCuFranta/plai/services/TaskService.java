package nuTinemCuFranta.plai.services;

import nuTinemCuFranta.plai.model.Task;
import nuTinemCuFranta.plai.model.Volunteer;
import nuTinemCuFranta.plai.repositories.TaskRepository;
import nuTinemCuFranta.plai.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task){
        taskRepository.save(task);
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).get();
    }

    public List<Task> getAllTasks(){
        return (List<Task>) taskRepository.findAll();
    }

    public void deleteTaskById(Long id)
    {
        taskRepository.deleteById(id);
    }
}
