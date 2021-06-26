package nuTinemCuFranta.plai.repositories;

import nuTinemCuFranta.plai.model.Project;
import nuTinemCuFranta.plai.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project,Long> {
    List<Project> findByOrganizationId(Long orgId);
}
