package nuTinemCuFranta.plai.repositories;

import nuTinemCuFranta.plai.model.Volunteer;
import nuTinemCuFranta.plai.model.VolunteerStatus;
import org.springframework.data.repository.CrudRepository;

public interface VolunteerRepository extends CrudRepository<Volunteer,Long> {
}
