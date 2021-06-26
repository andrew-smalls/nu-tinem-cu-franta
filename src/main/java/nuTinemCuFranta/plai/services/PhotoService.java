package nuTinemCuFranta.plai.services;

import nuTinemCuFranta.plai.model.Photo;
import nuTinemCuFranta.plai.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;


import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public void savePhoto(MultipartFile file, Long userId,Boolean isProfile){
        Photo photo=new Photo();

        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains("..")){
            System.out.println("Not a valid file!");
        }

        try {
            photo.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        photo.setUserId(userId);
        photo.setImageType(FilenameUtils.getExtension(fileName));
        photo.setProfile(isProfile);
        photoRepository.save(photo);
    }

    public void updateProfilePicture(Long photoId, Long userId){
        Photo oldProfilePicture=photoRepository.findByUserIdAndProfile(userId,true);

        if(oldProfilePicture!=null){
            oldProfilePicture.setProfile(false);
            photoRepository.save(oldProfilePicture);
        }

        Photo newProfilePicture = photoRepository.findById(photoId).get();
        newProfilePicture.setProfile(true);
        photoRepository.save(newProfilePicture);
    }

    public List<Photo> getPhotos(Long userId){
        return photoRepository.findByUserId(userId);
    }

    public Photo getProfilePhoto(Long userId){
        return photoRepository.findByUserIdAndProfile(userId,true);
    }

    public void deletePhoto(Long photoId){
        photoRepository.deleteById(photoId);
    }

}
