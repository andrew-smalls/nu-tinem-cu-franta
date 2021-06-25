package nuTinemCuFranta.plai.repositories;

import nuTinemCuFranta.plai.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
