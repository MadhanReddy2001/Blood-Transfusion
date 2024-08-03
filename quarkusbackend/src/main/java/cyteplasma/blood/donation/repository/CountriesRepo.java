package cyteplasma.blood.donation.repository;

import cyteplasma.blood.donation.entity.Countries;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CountriesRepo implements PanacheRepository<Countries>{

    public Countries findById(Long id) {
        return find("id", id).firstResult();
    }

    public Countries findByName(String name) {
    String lowerCaseName = name.toLowerCase();
    return find("LOWER(countryname)", lowerCaseName).firstResult();
    }
}
