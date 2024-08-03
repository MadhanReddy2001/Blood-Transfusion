package cyteplasma.blood.donation.DTO;

import java.util.List;

public class DistrictDTO {
    private Long Id;
    private String districtname;
    private List<PincodeDTO> pincodes;

    public Long getId(){
        return Id;
    }

    public void setId(Long Id){
        this.Id = Id;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public List<PincodeDTO> getPincodes() {
        return pincodes;
    }

    public void setPincodes(List<PincodeDTO> pincodes) {
        this.pincodes = pincodes;
    }
}

