package nuTinemCuFranta.plai.services;

import nuTinemCuFranta.plai.model.Notification;
import nuTinemCuFranta.plai.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public void addNotification(Notification notification){
        notificationRepository.save(notification);
    }

    public List<Notification> getAllUserNotifications(Long userId){
        return notificationRepository.findAllByUserId(userId);
    }

    public void deleteNotification(Long id){
        notificationRepository.deleteById(id);
    }

}
