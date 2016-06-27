package ge.edu.freeuni.sdp.iot.simulator.bath.service;

import ge.edu.freeuni.sdp.iot.simulator.bath.jaxb.LightSwitchPostRequest;
import ge.edu.freeuni.sdp.iot.simulator.bath.jaxb.VentSwitchPostRequest;
import ge.edu.freeuni.sdp.iot.simulator.bath.model.Bathroom;
import ge.edu.freeuni.sdp.iot.simulator.bath.model.VentSwitch;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bath")
@Produces({MediaType.APPLICATION_JSON})
public class BathroomService {

    @POST
    @Path("/light-switch")
    public Response switchLight(final LightSwitchPostRequest request) {
        if (request.getStatus().equals("ON")) {
            Bathroom.getInstance().turnLightOn();
            return Response.ok().build();
        }
        else if (request.getStatus().equals("OFF")) {
            Bathroom.getInstance().turnLightOff();
            return Response.ok().build();
        }
        return null;
    }

    @POST
    @Path("/vent-switch/{action}")
    public VentSwitch switchVent(@PathParam("action") String action) {
        VentSwitch ventSwitch = Bathroom.getInstance().getVentSwitch();

        if (action.toLowerCase().equals("no")) {
            Bathroom.getInstance().turnVentOn();
            return ventSwitch;
        }
        else if (action.toLowerCase().equals("off")) {
            Bathroom.getInstance().turnVentOff();
            return ventSwitch;
        }

        return ventSwitch;
    }

    @GET
    @Path("/vent-switch")
    public VentSwitch switchVent() {
        VentSwitch ventSwitch = Bathroom.getInstance().getVentSwitch();
        
        return ventSwitch;
    }
}
