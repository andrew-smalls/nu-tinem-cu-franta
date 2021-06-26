package nuTinemCuFranta.plai.controllers;

import nuTinemCuFranta.plai.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@Controller
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/addPhotos")
    public String savePhotos(@RequestParam("photos") MultipartFile[] photos, @RequestParam("orgId") Long orgId){
        Arrays.asList(photos).stream().forEach(photo -> {
            if(photo.getOriginalFilename().isEmpty()) {
                System.out.println("NU A FOST SELECTATA NICIO IMAGINE");
            }else {
                photoService.savePhoto(photo, orgId,false);
            }
        });
        return "redirect:/organization_photos_guests/"+orgId;
    }

    @PostMapping("/deletePhoto")
    public String deletePhoto(@RequestParam("photoId") Long photoId,@RequestParam("orgId") Long orgId){
        photoService.deletePhoto(photoId);
        return "redirect:/organization_photos_guests/"+orgId;
    }

    @PostMapping("/setAsProfile")
    public String setPhotoAsProfile(@RequestParam("photoId") Long photoId,@RequestParam("orgId") Long orgId){
        photoService.updateProfilePicture(photoId,orgId);
        return "redirect:/organization_photos_guests/"+orgId;
    }
}
