package nuTinemCuFranta.plai.services;

import nuTinemCuFranta.plai.model.Volunteer;
import nuTinemCuFranta.plai.model.VolunteerStatus;
import nuTinemCuFranta.plai.repositories.VolunteerRepository;
import nuTinemCuFranta.plai.repositories.VolunteerStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    public void addVolunteer(Volunteer volunteer){
        volunteerRepository.save(volunteer);
    }

    public Volunteer getVolunteerById(Long id){
        return volunteerRepository.findById(id).get();
    }

    public List<Volunteer> getAllVolunteers(){
        return (List<Volunteer>) volunteerRepository.findAll();
    }

    public void deleteVolunteerById(Long id)
    {
        volunteerRepository.deleteById(id);
    }
}
