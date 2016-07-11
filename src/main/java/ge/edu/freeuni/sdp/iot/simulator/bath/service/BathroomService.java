package ge.edu.freeuni.sdp.iot.simulator.bath.service;

import ge.edu.freeuni.sdp.iot.simulator.bath.model.DryerSwitchPostRequest;
import ge.edu.freeuni.sdp.iot.simulator.bath.model.LightSwitchPostRequest;
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
    @Path("/vent-switch/")
    public VentSwitch switchVent(String action) {

        if (action.toLowerCase().equals("on")) {
            Bathroom.getInstance().turnVentOn();
            return Bathroom.getInstance().getVentSwitch();
        }
        else if (action.toLowerCase().equals("off")) {
            Bathroom.getInstance().turnVentOff();
            return Bathroom.getInstance().getVentSwitch();
        }

        return Bathroom.getInstance().getVentSwitch();
    }

    @GET
    @Path("/vent-switch")
    public VentSwitch switchVent() {
        VentSwitch ventSwitch = Bathroom.getInstance().getVentSwitch();
        
        return ventSwitch;
    }

    @POST
    @Path("/dryer-switch")
    public Response switchDryer(final DryerSwitchPostRequest request) {
        if (request.getStatus().equals("ON")) {
            Bathroom.getInstance().turnDryerOn();
            return Response.ok().build();
        }
        else if (request.getStatus().equals("OFF")) {
            Bathroom.getInstance().turnDryerOff();
            return Response.ok().build();
        }
        return null;
    }
}
