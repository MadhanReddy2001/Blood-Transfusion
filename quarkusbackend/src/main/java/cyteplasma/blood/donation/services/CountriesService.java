package cyteplasma.blood.donation.services;

import java.util.List;
import java.util.stream.Collectors;

import cyteplasma.blood.donation.DTO.CountryDTO;
import cyteplasma.blood.donation.DTO.DistrictDTO;
import cyteplasma.blood.donation.DTO.PincodeDTO;
import cyteplasma.blood.donation.DTO.StateDTO;
import cyteplasma.blood.donation.entity.Countries;
import cyteplasma.blood.donation.entity.Districts;
import cyteplasma.blood.donation.entity.Pincodes;
import cyteplasma.blood.donation.entity.States;
import cyteplasma.blood.donation.mapper.DistrictMapper;
import cyteplasma.blood.donation.mapper.PincodeMapper;
import cyteplasma.blood.donation.mapper.StateMapper;
import cyteplasma.blood.donation.repository.CountriesRepo;
import cyteplasma.blood.donation.repository.DistrictsRepo;
import cyteplasma.blood.donation.repository.PincodesRepo;
import cyteplasma.blood.donation.repository.StatesRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
@ApplicationScoped
public class CountriesService {

    @Inject
    CountriesRepo countryRepository;

    @Inject
    StatesRepo stateRepository;

    @Inject
    DistrictsRepo districtRepository;

    @Inject
    PincodesRepo pincodeRepository;

    // To save the data into DB
    @Transactional
    public void createOrUpdateCountries(List<CountryDTO> countryDTOs) {
    for (CountryDTO countryDTO : countryDTOs) {
        Countries existingCountry = countryRepository.findByName(countryDTO.getCountryname());
        if(existingCountry ==null){
            Countries country = new Countries();
            country.setCountryname(countryDTO.getCountryname());
            countryRepository.persist(country);
            for (StateDTO stateDTO : countryDTO.getStates()) {
                States state = new States();
                state.setStatename(stateDTO.getStatename());
                state.setCountries(country);
                stateRepository.persist(state);
                for (DistrictDTO districtDTO : stateDTO.getDistricts()) {
                    Districts district = new Districts();
                    district.setDistrictname(districtDTO.getDistrictname());
                    district.setStates(state);
                    districtRepository.persist(district);
                    for (PincodeDTO pincodeDTO : districtDTO.getPincodes()) {
                        Pincodes pincode = new Pincodes();
                        pincode.setPincode(pincodeDTO.getPincode());
                        pincode.setDistricts(district);
                        pincode.setCities(pincodeDTO.getCities());
                        pincodeRepository.persist(pincode);
                    }
                }
            }
        }
        else{
            updateCountryEntity(existingCountry, countryDTO);
            countryRepository.persist(existingCountry);
        }
    }
}

    private void updateCountryEntity(Countries existingCountry, CountryDTO countryDTO) {
        existingCountry.setCountryname(countryDTO.getCountryname());
        // Update States
        for (StateDTO stateDTO : countryDTO.getStates()) {
            States existingState = findStateByName(existingCountry.getStates(), stateDTO.getStatename());
            if (existingState != null) {
                updateStateEntity(existingState, stateDTO);
            } else {
                States newState = StateMapper.toEntity(stateDTO);
                existingCountry.getStates().add(newState);
                newState.setCountries(existingCountry);
                for (DistrictDTO districtDTO : stateDTO.getDistricts()) {
                    Districts district = new Districts();
                    district.setDistrictname(districtDTO.getDistrictname());
                    district.setStates(newState);
                    districtRepository.persist(district);
                    for (PincodeDTO pincodeDTO : districtDTO.getPincodes()) {
                        Pincodes pincode = new Pincodes();
                        pincode.setPincode(pincodeDTO.getPincode());
                        pincode.setDistricts(district);
                        pincode.setCities(pincodeDTO.getCities());
                        pincodeRepository.persist(pincode);
                    }
                }
            }
        }
    }

    private void updateStateEntity(States existingState, StateDTO stateDTO) {
        existingState.setStatename(stateDTO.getStatename());
        // Update Districts
        for (DistrictDTO districtDTO : stateDTO.getDistricts()) {
            Districts existingDistrict = findDistrictByName(existingState.getDistricts(), districtDTO.getDistrictname());
            if (existingDistrict != null) {
                updateDistrictEntity(existingDistrict, districtDTO);
            } else {
                Districts newDistrict = DistrictMapper.toEntity(districtDTO);
                existingState.getDistricts().add(newDistrict);
                newDistrict.setStates(existingState);
                for (PincodeDTO pincodeDTO : districtDTO.getPincodes()) {
                    Pincodes pincode = new Pincodes();
                    pincode.setPincode(pincodeDTO.getPincode());
                    pincode.setDistricts(newDistrict);
                    pincode.setCities(pincodeDTO.getCities());
                    pincodeRepository.persist(pincode);
                }
            }
        }
    }

    private void updateDistrictEntity(Districts existingDistrict, DistrictDTO districtDTO) {
        existingDistrict.setDistrictname(districtDTO.getDistrictname());
        // Update Pincodes
        for (PincodeDTO pincodeDTO : districtDTO.getPincodes()) {
            Pincodes existingPincode = findPincodeByCode(existingDistrict.getPincodes(), pincodeDTO.getPincode());
            if (existingPincode != null) {
                updatePincodeEntity(existingPincode, pincodeDTO);
            } else {
                Pincodes newPincode = PincodeMapper.toEntity(pincodeDTO);
                existingDistrict.getPincodes().add(newPincode);
                newPincode.setDistricts(existingDistrict);
            }
        }
    }

    private void updatePincodeEntity(Pincodes existingPincode, PincodeDTO pincodeDTO) {
        existingPincode.setPincode(pincodeDTO.getPincode());
        existingPincode.setCities(pincodeDTO.getCities());
    } 

    private Countries findCountryByName(List<Countries> countries, String name) {
        String sanitizedInputName = name.replaceAll("\\s", "").toLowerCase();
        return countries.stream()
                .filter(c -> c.getCountryname().replaceAll("\\s", "").toLowerCase().equals(sanitizedInputName))
                .findFirst()
                .orElse(null);
    }    

    private States findStateByName(List<States> states, String name) {
        String sanitizedStateName = name.replaceAll("\\s", "").toLowerCase();
        return states.stream()
            .filter(s -> s.getStatename().replaceAll("\\s", "").toLowerCase().equals(sanitizedStateName))
            .findFirst()
            .orElse(null);
    }
    
    private Districts findDistrictByName(List<Districts> districts, String name) {
        String sanitizedDistrictName = name.replaceAll("\\s", "").toLowerCase();
        return districts.stream()
            .filter(d -> d.getDistrictname().replaceAll("\\s", "").toLowerCase().equals(sanitizedDistrictName))
            .findFirst()
            .orElse(null);
    }
    
    private Pincodes findPincodeByCode(List<Pincodes> pincodes, String code) {
        String sanitizedPinCode = code.replaceAll("\\s", "").toLowerCase();
        return pincodes.stream()
            .filter(p -> p.getPincode().replaceAll("\\s", "").toLowerCase().equals(sanitizedPinCode))
            .findFirst()
            .orElse(null);
    }    

    //To get the data from the DB
    // @Transactional
    // public CountryListDTO getAllCountries() {
    //     List<CountryDTO> countryDTOs = countryRepository.findAll()
    //     .stream()
    //     .map(this::mapToDTO)
    //     .collect(Collectors.toList());

    //       return new CountryListDTO(countryDTOs); 
    // }

        @Transactional
        public List<CountryDTO> getAllCountries() {
            return countryRepository.findAll()
                    .stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        }


    private CountryDTO mapToDTO(Countries country) {
        CountryDTO dto = new CountryDTO();
        dto.setId(country.getId());
        dto.setCountryname(country.getCountryname());
        dto.setStates(country.getStates().stream()
                .map(state -> {
                    StateDTO stateDTO = new StateDTO();
                    stateDTO.setId(state.getId());
                    stateDTO.setStatename(state.getStatename());
                    stateDTO.setDistricts(state.getDistricts().stream()
                            .map(district -> {
                                DistrictDTO districtDTO = new DistrictDTO();
                                districtDTO.setId(district.getId());
                                districtDTO.setDistrictname(district.getDistrictname());
                                districtDTO.setPincodes(district.getPincodes().stream()
                                        .map(pincode -> {
                                            PincodeDTO pincodeDTO = new PincodeDTO();
                                            pincodeDTO.setId(pincode.getId());
                                            pincodeDTO.setPincode(pincode.getPincode());
                                            pincodeDTO.setCities(pincode.getCities());
                                            return pincodeDTO;
                                        })
                                        .collect(Collectors.toList()));
                                return districtDTO;
                            })
                            .collect(Collectors.toList()));
                    return stateDTO;
                })
                .collect(Collectors.toList()));
        return dto;
    }
}
