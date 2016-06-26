package ge.edu.freeuni.sdp.iot.simulator.bath.service;

import ge.edu.freeuni.sdp.iot.simulator.bath.jaxb.VentSwitchPostRequest;
import ge.edu.freeuni.sdp.iot.simulator.bath.model.Bathroom;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by mi.maghriani on 6/26/2016.
 */
@Path("/change_mode/mode")
@Consumes({MediaType.APPLICATION_JSON})
public class BathVentService {
    @GET
    public Response get(@PathParam("mode") String mode) {
        VentSwitchPostRequest request = new VentSwitchPostRequest();

        if (mode.equals("ON")) {
            Bathroom.getInstance().turnVentOn();
        }
        else if (mode.equals("OFF")) {
            Bathroom.getInstance().turnVentOff();
        }
        request.status = "ok";

        return Response.ok().build();
    }
}
