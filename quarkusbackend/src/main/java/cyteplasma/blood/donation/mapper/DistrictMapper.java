package cyteplasma.blood.donation.mapper;

import java.util.stream.Collectors;

import cyteplasma.blood.donation.DTO.DistrictDTO;
import cyteplasma.blood.donation.entity.Districts;

public class DistrictMapper {
public static DistrictDTO toDTO(Districts district) {
        DistrictDTO dto = new DistrictDTO();
        dto.setId(district.getId());
        dto.setDistrictname(district.getDistrictname());
        dto.setPincodes(district.getPincodes().stream().map(PincodeMapper::toDTO).collect(Collectors.toList()));
        return dto;
    }

    public static Districts toEntity(DistrictDTO dto) {
        Districts district = new Districts();
        district.setId(dto.getId());
        district.setDistrictname(dto.getDistrictname());
        district.setPincodes(dto.getPincodes().stream().map(PincodeMapper::toEntity).collect(Collectors.toList()));
        return district;
    }
}
