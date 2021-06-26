package nuTinemCuFranta.plai.controllers;

import nuTinemCuFranta.plai.model.Notification;
import nuTinemCuFranta.plai.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("getNotifications")
    public ResponseEntity<Object> getAllNotifications(){
        List<Notification> response=notificationService.getAllUserNotifications(Long.valueOf(3));
        return new ResponseEntity<Object>(response,HttpStatus.OK);
    }
}
