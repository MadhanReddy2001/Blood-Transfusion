package cyteplasma.blood.donation.repository;

import cyteplasma.blood.donation.entity.Pincodes;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PincodesRepo implements PanacheRepository<Pincodes>{

    public Pincodes findByPincodeIgnoreCase(String pincode) {
        return find("pincode", pincode).firstResult();
    }
}
