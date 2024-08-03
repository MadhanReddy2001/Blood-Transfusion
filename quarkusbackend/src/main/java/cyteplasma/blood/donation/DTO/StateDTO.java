package cyteplasma.blood.donation.DTO;
import java.util.List;

public class StateDTO {
    private Long Id;
    public String statename;
    public List<DistrictDTO> districts;

    public Long getId(){
        return Id;
    }

    public void setId(Long Id){
        this.Id = Id;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public List<DistrictDTO> getDistricts() {
        return districts;
    }

    public void setDistricts(List<DistrictDTO> districts) {
        this.districts = districts;
    }
}

