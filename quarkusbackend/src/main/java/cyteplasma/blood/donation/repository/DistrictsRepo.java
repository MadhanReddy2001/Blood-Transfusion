package cyteplasma.blood.donation.repository;

import cyteplasma.blood.donation.entity.Districts;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DistrictsRepo implements PanacheRepository<Districts>{

     public Districts findByNameIgnoreCase(String name) {
        return find("districtname", name).firstResult();
    }
}
