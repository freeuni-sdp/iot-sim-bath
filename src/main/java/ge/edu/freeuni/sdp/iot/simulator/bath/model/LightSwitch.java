package ge.edu.freeuni.sdp.iot.simulator.bath.model;

import ge.edu.freeuni.sdp.iot.simulator.bath.jaxb.MyJaxBean;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class LightSwitch {
    private String houseId;

    private static final String URI = "http://iot-bath-light-sensor.herokuapp.com/webapi/status/house/";

    public LightSwitch(String houseId) {
        this.houseId = houseId;
    }

    public Response lightOn() {
        return sendPostRequest("on");
    }

    public Response lightOff() {
        return sendPostRequest("off");
    }

    private Response sendPostRequest(String status){
        WebTarget target = ClientBuilder.newClient().target(URI + houseId);
        MyJaxBean jaxb = new MyJaxBean();
        jaxb.setHouseId(houseId);
        jaxb.setStatus(status);
        Entity<MyJaxBean> humEntity = Entity.entity(jaxb, MediaType.APPLICATION_JSON);

        return target.request(MediaType.APPLICATION_JSON).post(humEntity, Response.class);
    }
}
