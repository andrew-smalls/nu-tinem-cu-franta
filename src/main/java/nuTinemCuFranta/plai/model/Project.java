package nuTinemCuFranta.plai.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="projects")
public class Project {

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

    private String projectName;
    private String organizationName;
    private String projectCoordinator;
    private String projectStatus;


    public Project(String projectName, String organizationName, String projectCoordinator) {
        this.projectName = projectName;
        this.organizationName = organizationName;
        this.projectCoordinator = projectCoordinator;
        this.projectStatus = "In progress";
    }

    public Project() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id.equals(project.id) &&
                projectName.equals(project.projectName);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", projectCoordinator='" + projectCoordinator + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getProjectCoordinator() {
        return projectCoordinator;
    }

    public void setProjectCoordinator(String projectCoordinator) {
        this.projectCoordinator = projectCoordinator;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

}
