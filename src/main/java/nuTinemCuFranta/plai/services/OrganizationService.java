package nuTinemCuFranta.plai.services;

import nuTinemCuFranta.plai.model.Organization;
import nuTinemCuFranta.plai.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public void addOrganization(Organization organization){
        organizationRepository.save(organization);
    }

    public Organization getOrganization(Long id){
        return organizationRepository.findById(id).get();
    }

    public List<Organization> getAllOrganizations(){
        return (List<Organization>) organizationRepository.findAll();
    }

    public List<Organization> searchOrganizations(String text){
        return organizationRepository.findByText(text);
    }

    public void deleteOrganization(Long id){
        organizationRepository.deleteById(id);
    }

    public void updateOrganisationStatus(Long id,String status){
        Organization organization = organizationRepository.findById(id).get();
        organization.setStatus(status);
        organizationRepository.save(organization);
    }
}
