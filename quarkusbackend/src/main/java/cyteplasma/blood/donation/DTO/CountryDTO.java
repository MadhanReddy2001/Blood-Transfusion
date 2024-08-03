package cyteplasma.blood.donation.DTO;

import java.util.ArrayList;
import java.util.List;

public class CountryDTO {
    private Long id;
    private String countryname;
    private List<StateDTO> states = new ArrayList<>();

    public CountryDTO() {
    }

    public CountryDTO(Long id, String countryname, List<StateDTO> states) {
        this.id = id;
        this.countryname = countryname;
        this.states = states;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public List<StateDTO> getStates() {
        return states;
    }

    public void setStates(List<StateDTO> states) {
        this.states = states;
    }
    
}