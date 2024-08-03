package cyteplasma.blood.donation.services;

import cyteplasma.blood.donation.entity.DonorDetails;
import cyteplasma.blood.donation.repository.DonorDetailsRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DistrictsService {

    @Inject
    DonorDetailsRepo donorDetailsRepository;

    @Transactional
    public void saveDonorDetails(DonorDetails donorDetails) {
        donorDetailsRepository.persist(donorDetails);
    }
}
