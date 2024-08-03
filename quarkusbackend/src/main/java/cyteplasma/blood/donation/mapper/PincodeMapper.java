package cyteplasma.blood.donation.mapper;

import cyteplasma.blood.donation.DTO.PincodeDTO;
import cyteplasma.blood.donation.entity.Pincodes;

public class PincodeMapper {

    public static PincodeDTO toDTO(Pincodes pincode) {
        PincodeDTO dto = new PincodeDTO();
        dto.setId(pincode.getId());
        dto.setPincode(pincode.getPincode());
        dto.setCities(pincode.getCities());
        return dto;
    }

    public static Pincodes toEntity(PincodeDTO dto) {
        Pincodes pincode = new Pincodes();
        pincode.setId(dto.getId());
        pincode.setPincode(dto.getPincode());
        pincode.setCities(dto.getCities());
        return pincode;
    }
}
