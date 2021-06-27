package nuTinemCuFranta.plai.repositories;

import nuTinemCuFranta.plai.model.Project;
import nuTinemCuFranta.plai.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends CrudRepository<Project,Long> {
    List<Project> findByOrganizationId(Long orgId);

    @Query(
            value = "SELECT * FROM projects WHERE project_name = ?1",
            nativeQuery = true
    )
    Optional<Project> findByProjectName(String projectName);
}
