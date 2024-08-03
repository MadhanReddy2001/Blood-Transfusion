package cyteplasma.blood.donation.resourcescontroller;

import java.util.List;

import cyteplasma.blood.donation.DTO.CountryDTO;
import cyteplasma.blood.donation.services.CountriesService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/api/countries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CountriesResources {

    @Inject
    CountriesService countriesService;
 
    @POST
    @Path("/addlocation")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrUpdateCountries(List<CountryDTO> countryDTOs) {
        try {
            countriesService.createOrUpdateCountries(countryDTOs);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to create/update countries: " + e.getMessage()).build();
        }
    }
    
    @GET
    @Path("/getlocation")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<CountryDTO> getAllCountries() {
        return countriesService.getAllCountries();
    }
    
}
