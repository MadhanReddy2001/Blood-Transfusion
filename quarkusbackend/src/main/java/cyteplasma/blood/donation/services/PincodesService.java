package cyteplasma.blood.donation.services;

import java.util.List;

import cyteplasma.blood.donation.entity.Pincodes;
import cyteplasma.blood.donation.repository.PincodesRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PincodesService {
@Inject
    PincodesRepo pincodeRepository;

    @Transactional
    public List<Pincodes> getAllPincodes() {
        return pincodeRepository.listAll();
    }
}
