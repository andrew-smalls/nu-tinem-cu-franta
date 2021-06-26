package nuTinemCuFranta.plai.repositories;

import nuTinemCuFranta.plai.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

        @Query("SELECT u FROM User u WHERE u.email = ?1")
        public User findByEmail(String email);

}
