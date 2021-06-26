package nuTinemCuFranta.plai.repositories;

import nuTinemCuFranta.plai.model.Organization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<Organization,Long> {

    @Query("SELECT o FROM Organization o WHERE o.name LIKE %?1%")
    public List<Organization> findByText(String text);

}
