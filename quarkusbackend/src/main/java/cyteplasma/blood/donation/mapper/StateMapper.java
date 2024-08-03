package cyteplasma.blood.donation.mapper;

import cyteplasma.blood.donation.DTO.StateDTO;
import cyteplasma.blood.donation.entity.States;

public class StateMapper {
public static StateDTO toDTO(States state) {
        StateDTO dto = new StateDTO();
        dto.setId(state.getId());
        dto.setStatename(state.getStatename());
        // dto.setDistricts(state.getDistricts().stream().map(DistrictMapper::toDTO).collect(Collectors.toList()));
        return dto;
    }

    public static States toEntity(StateDTO dto) {
        States state = new States();
        state.setId(dto.getId());
        state.setStatename(dto.getStatename());
        // state.setDistricts(dto.getDistricts().stream().map(DistrictMapper::toEntity).collect(Collectors.toList()));
        return state;
    }
}
