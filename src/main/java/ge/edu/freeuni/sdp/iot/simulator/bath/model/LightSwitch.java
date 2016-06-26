package ge.edu.freeuni.sdp.iot.simulator.bath.model;

import ge.edu.freeuni.sdp.iot.simulator.bath.jaxb.MyJaxBean;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class LightSwitch {
    private String houseId;

    public LightSwitch(String houseId) {
        this.houseId = houseId;
    }

    public void lightOn() {
        //TODO send post request to https://iot-bath-light-sensor.herokuapp.com/
        WebTarget target = ClientBuilder.newClient().target("http://iot-bath-light-sensor.herokuapp.com/webapi/houses/" + houseId);
        MyJaxBean jaxb = new MyJaxBean();
        jaxb.houseId = houseId;
        jaxb.status = "on";
        target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(jaxb));
    }

    public void lightOff() {
        //TODO send post request to https://iot-bath-light-sensor.herokuapp.com/
        WebTarget target = ClientBuilder.newClient().target("http://iot-bath-light-sensor.herokuapp.com/webapi/houses/" + houseId);
        MyJaxBean jaxb = new MyJaxBean();
        jaxb.houseId = houseId;
        jaxb.status = "off";
        target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(jaxb));
    }
}
