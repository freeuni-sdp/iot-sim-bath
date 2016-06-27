package ge.edu.freeuni.sdp.iot.simulator.bath.model;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class LightSwitch {
    private String houseId;

    private boolean isSwitchOn;

    private static final String URI = "http://iot-bath-light-sensor.herokuapp.com/webapi/status/";

    public LightSwitch(String houseId) {
        this.houseId = houseId;
    }

    public Response lightOn() {
        Response response = sendPostRequest("on");
        if (response.getStatus() == Response.ok().build().getStatus())
            isSwitchOn = true;
        return response;
    }

    public Response lightOff() {
        Response response = sendPostRequest("off");
        if (response.getStatus() == Response.ok().build().getStatus())
            isSwitchOn = true;
        return response;
    }

    private Response sendPostRequest(String status){
        WebTarget target = ClientBuilder.newClient().target(URI);
        LightSwitchStatus jaxb = new LightSwitchStatus();
        jaxb.setHouseId(houseId);
        jaxb.setStatus(status);
        Entity<LightSwitchStatus> lightEntity = Entity.entity(jaxb, MediaType.APPLICATION_JSON);

        return target.request(MediaType.APPLICATION_JSON).post(lightEntity, Response.class);
    }

    public boolean isSwitchOn() {
        return isSwitchOn;
    }
}
