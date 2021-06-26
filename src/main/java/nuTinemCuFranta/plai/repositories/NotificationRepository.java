package nuTinemCuFranta.plai.repositories;

import nuTinemCuFranta.plai.model.Notification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotificationRepository extends CrudRepository<Notification,Long> {
    public List<Notification> findAllByUserId(Long userId);
}
