package cyteplasma.blood.donation.mapper;

import java.util.stream.Collectors;

import cyteplasma.blood.donation.DTO.CountryDTO;
import cyteplasma.blood.donation.entity.Countries;

public class CountryMapper {
public static CountryDTO toDTO(Countries country) {
        CountryDTO dto = new CountryDTO();
        dto.setId(country.getId());
        dto.setCountryname(country.getCountryname());
        dto.setStates(country.getStates().stream().map(StateMapper::toDTO).collect(Collectors.toList()));
        return dto;
    }

    public static Countries toEntity(CountryDTO dto) {
        Countries country = new Countries();
        country.setId(dto.getId());
        country.setCountryname(dto.getCountryname());
        country.setStates(dto.getStates().stream().map(StateMapper::toEntity).collect(Collectors.toList()));
        return country;
    }
}
