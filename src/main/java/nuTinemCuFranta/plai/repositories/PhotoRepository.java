package nuTinemCuFranta.plai.repositories;

import nuTinemCuFranta.plai.model.Photo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhotoRepository extends CrudRepository<Photo,Long> {
    List<Photo> findByUserId(Long userId);
    Photo findByUserIdAndProfile(Long userId,Boolean profile);
}
