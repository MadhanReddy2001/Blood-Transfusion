package cyteplasma.blood.donation.DTO;

import java.util.List;

public class PincodeDTO {
    private Long Id;
    private String pincode;
    private List<String> cities;

    public Long getId(){
        return Id;
    }

    public void setId(Long Id){
        this.Id = Id;
    }
    
    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }
}

