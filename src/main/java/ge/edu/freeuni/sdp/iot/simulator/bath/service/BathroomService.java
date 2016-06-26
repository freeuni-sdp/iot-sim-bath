package ge.edu.freeuni.sdp.iot.simulator.bath.service;

import ge.edu.freeuni.sdp.iot.simulator.bath.jaxb.LightSwitchPostRequest;
import ge.edu.freeuni.sdp.iot.simulator.bath.jaxb.VentSwitchPostRequest;
import ge.edu.freeuni.sdp.iot.simulator.bath.model.Bathroom;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class BathroomService {


    @POST
    @Path("/light-switch")
    @Consumes({MediaType.APPLICATION_JSON})
    public void switchLight(final LightSwitchPostRequest request) {
        if (request.status.equals("ON")) {
            Bathroom.getInstance().turnLightOn();
        }
        else if (request.status.equals("OFF")) {
            Bathroom.getInstance().turnLightOff();
        }
    }

    @POST
    @Path("/change_mode/mode")
    @Consumes({MediaType.APPLICATION_JSON})
    public VentSwitchPostRequest post(@PathParam("change_mode") String mode) {
        VentSwitchPostRequest request = new VentSwitchPostRequest();

        if (mode.equals("ON")) {
            Bathroom.getInstance().turnVentOn();
        }
        else if (mode.equals("OFF")) {
            Bathroom.getInstance().turnVentOff();
        }
        request.status = "ok";
        return request;
    }
}
