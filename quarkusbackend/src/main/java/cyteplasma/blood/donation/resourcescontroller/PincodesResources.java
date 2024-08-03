package cyteplasma.blood.donation.resourcescontroller;

import java.util.List;

import cyteplasma.blood.donation.entity.Pincodes;
import cyteplasma.blood.donation.services.PincodesService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/pincodes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PincodesResources {
    @Inject
    PincodesService pincodeService;

    @GET
    public List<Pincodes> getAllPincodes() {
        return pincodeService.getAllPincodes();
    }
}
