package cyteplasma.blood.donation.repository;

import cyteplasma.blood.donation.entity.States;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StatesRepo implements PanacheRepository<States>{

     public States findByNameIgnoreCase(String name) {
        return find("statename", name).firstResult();
    }
}
