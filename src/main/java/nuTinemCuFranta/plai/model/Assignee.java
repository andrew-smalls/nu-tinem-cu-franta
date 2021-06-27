package nuTinemCuFranta.plai.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="tasks")
public class Assignee {

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

    @Column(name = "taskId")
    private Long taskId;

    @Column(name = "volunteerId")
    private Long volunteerId;

    public Assignee(Long taskId, Long volunteerId) {
        this.taskId = taskId;
        this.volunteerId = volunteerId;
    }

    public Assignee() {
    }

    @Override
    public String toString() {
        return "Assignee{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", volunteerId=" + volunteerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignee assignee = (Assignee) o;
        return Objects.equals(id, assignee.id) &&
                Objects.equals(taskId, assignee.taskId) &&
                Objects.equals(volunteerId, assignee.volunteerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskId, volunteerId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }
}
