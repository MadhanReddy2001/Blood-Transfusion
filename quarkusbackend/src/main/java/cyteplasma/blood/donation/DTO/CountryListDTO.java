package cyteplasma.blood.donation.DTO;

import java.util.List;

public class CountryListDTO {
 private List<CountryDTO> countries;

    public CountryListDTO(List<CountryDTO> countries) {
        this.countries = countries;
    }

    public List<CountryDTO> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryDTO> countries) {
        this.countries = countries;
    }
}
