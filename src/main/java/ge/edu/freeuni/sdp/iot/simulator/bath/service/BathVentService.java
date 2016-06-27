package ge.edu.freeuni.sdp.iot.simulator.bath.service;

import ge.edu.freeuni.sdp.iot.simulator.bath.jaxb.VentSwitchPostRequest;
import ge.edu.freeuni.sdp.iot.simulator.bath.model.Bathroom;
import ge.edu.freeuni.sdp.iot.simulator.bath.model.VentSwitch;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by mi.maghriani on 6/26/2016.
 */
@Path("/status")
@Produces({MediaType.APPLICATION_JSON})
public class BathVentService {
    @GET
    public VentSwitch get() {
        VentSwitchPostRequest request = new VentSwitchPostRequest();
        VentSwitch ventSwitch = Bathroom.getInstance().getVentSwitch();

        return ventSwitch;
    }
}
