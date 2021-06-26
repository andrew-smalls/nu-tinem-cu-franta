package nuTinemCuFranta.plai.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;

    @Column(name = "projectId")
    private Long projectId;

    private String taskName;
    private String taskGiver;
    private String taskStatus;

    public Task(Long projectId, String taskName, String taskGiver, String taskStatus) {
        this.projectId = projectId;
        this.taskName = taskName;
        this.taskGiver = taskGiver;
        this.taskStatus = taskStatus;
    }

    public Task() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.projectId) &&
                Objects.equals(projectId, task.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskGiver() {
        return taskGiver;
    }

    public void setTaskGiver(String taskGiver) {
        this.taskGiver = taskGiver;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

}
