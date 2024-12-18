package cyteplasma.blood.donation.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cyteplasma.blood.donation.DTO.DonorDetailsDTO;
import cyteplasma.blood.donation.entity.DonorDetails;
import cyteplasma.blood.donation.repository.DonorDetailsRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DonorDetailsService {
    @Inject
    DonorDetailsRepo donorDetailsRepository;

    @Transactional
    public DonorDetails saveDonorDetails(DonorDetailsDTO donorDetailsDTO) {
        DonorDetails donorDetails = new DonorDetails();
        donorDetails.setDonorname(donorDetailsDTO.getDonorname());
        donorDetails.setBloodgroup(donorDetailsDTO.getBloodgroup());
        donorDetails.setMobileno(donorDetailsDTO.getMobileno());
        donorDetails.setCountryname(donorDetailsDTO.getCountryname());
        donorDetails.setStatename(donorDetailsDTO.getStatename());
        donorDetails.setDistrictname(donorDetailsDTO.getDistrictname());
        donorDetails.setCity(donorDetailsDTO.getCity());
        donorDetails.setPincode(donorDetailsDTO.getPincode());
        donorDetails.setAlcohol(donorDetailsDTO.getAlcohol());
        donorDetails.setAnemia(donorDetailsDTO.getAnemia());
        donorDetails.setBloodgroup(donorDetailsDTO.getBloodgroup());
        donorDetails.setBp(donorDetailsDTO.getBp());
        donorDetails.setDiabetic(donorDetailsDTO.getDiabetic());
        donorDetails.setHiv(donorDetailsDTO.getHiv());
        donorDetails.setMedicaltreatment(donorDetailsDTO.getMedicaltreatment());
        donorDetails.setPreviousdonation(donorDetailsDTO.getPreviousdonation());
        donorDetailsRepository.persist(donorDetails);
        return donorDetails;
    }

    @Transactional
    public List<DonorDetailsDTO> listAllDonors() {
        List<DonorDetails> donors = donorDetailsRepository.listAll();
        return donors.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private DonorDetailsDTO mapToDTO(DonorDetails donorDetails) {
        DonorDetailsDTO dto = new DonorDetailsDTO();
        dto.setId(donorDetails.getId());
        dto.setDonorname(donorDetails.getDonorname());
        dto.setBloodgroup(donorDetails.getBloodgroup());
        dto.setMobileno(donorDetails.getMobileno());
        dto.setCountryname(donorDetails.getCountryname());
        dto.setStatename(donorDetails.getStatename());
        dto.setDistrictname(donorDetails.getDistrictname());
        dto.setCity(donorDetails.getCity());
        dto.setPincode(donorDetails.getPincode());
        dto.setAnemia(donorDetails.getAnemia());
        dto.setAlcohol(donorDetails.getAlcohol());
        dto.setBp(donorDetails.getBp());
        dto.setDiabetic(donorDetails.getDiabetic());
        dto.setHiv(donorDetails.getHiv());
        dto.setMedicaltreatment(donorDetails.getMedicaltreatment());
        dto.setPreviousdonation(donorDetails.getPreviousdonation());
        return dto;
    }

    @Transactional
    public Map<String, Long> getCountByBloodGroups() {
        return donorDetailsRepository.getCountByBloodGroups();
    }

    @Transactional
    public List<DonorDetails> searchDonors(String bloodgroup, String countryname, String statename, String city) {

        List<DonorDetails> findDonorDetails = donorDetailsRepository.findDonorsByFilters(bloodgroup, countryname, statename, city);
        return  findDonorDetails;
    }
}
