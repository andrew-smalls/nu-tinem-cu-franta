package nuTinemCuFranta.plai.services;

import nuTinemCuFranta.plai.model.User;
import nuTinemCuFranta.plai.model.VolunteerStatus;
import nuTinemCuFranta.plai.repositories.UserRepository;
import nuTinemCuFranta.plai.repositories.VolunteerStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerStatusService {

    @Autowired
    private VolunteerStatusRepository volunteerStatusRepository;

    public void addStatus(VolunteerStatus status){
        volunteerStatusRepository.save(status);
    }

    public VolunteerStatus getStatusById(Long id){
        return volunteerStatusRepository.findById(id).get();
    }

    public List<VolunteerStatus> getAllVolunteerStatus(){
        return (List<VolunteerStatus>) volunteerStatusRepository.findAll();
    }
}
