package ge.edu.freeuni.sdp.iot.simulator.bath.service;



import ge.edu.freeuni.sdp.iot.simulator.bath.model.LightSwitchPostRequest;
import ge.edu.freeuni.sdp.iot.simulator.bath.model.Bathroom;
import ge.edu.freeuni.sdp.iot.simulator.bath.model.VentSwitch;
import org.json.JSONObject;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ScheduledExecutorService;

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

        JSONObject json = new JSONObject(action);
        String state = json.getString("set_status");

        if (state.toLowerCase().equals("on")) {
            Bathroom.getInstance().turnVentOn();
            return Bathroom.getInstance().getVentSwitch();
        }
        else if (state.toLowerCase().equals("off")) {
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

    @PostConstruct
    public static void init(){
        Bathroom.getInstance();
    }
}
