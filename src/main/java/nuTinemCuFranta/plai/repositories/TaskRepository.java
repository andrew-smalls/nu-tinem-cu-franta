package nuTinemCuFranta.plai.repositories;

import nuTinemCuFranta.plai.model.Task;
import nuTinemCuFranta.plai.model.Volunteer;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Long> {
}
