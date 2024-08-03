package cyteplasma.blood.donation.resourcescontroller;

import java.util.List;
import java.util.Map;

import cyteplasma.blood.donation.DTO.DonorDetailsDTO;
import cyteplasma.blood.donation.services.DonorDetailsService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/api/donordetails")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DonorDetailsResources {

    @Inject
    DonorDetailsService donorDetailsService;

    @POST
    @Path("/adddonor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveDonorDetails(DonorDetailsDTO donorDetailsDTO) {
        donorDetailsService.saveDonorDetails(donorDetailsDTO);
        return Response.status(Response.Status.CREATED).entity(donorDetailsDTO).build();
    }

    @GET
    @Path("/viewdonor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDonorDetails() {
        List<DonorDetailsDTO> donors = donorDetailsService.listAllDonors();
        return Response.ok(donors).build();
    }

    @GET
    @Path("/counts")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Long> getCountByBloodGroups() {
        return donorDetailsService.getCountByBloodGroups();
    }
}
