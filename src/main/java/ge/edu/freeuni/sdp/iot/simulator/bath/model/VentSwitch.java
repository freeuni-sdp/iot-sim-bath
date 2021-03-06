package ge.edu.freeuni.sdp.iot.simulator.bath.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by khrak on 6/25/16.
 */
@XmlRootElement
public class VentSwitch {

    @XmlElement
    private String status;

    @XmlElement
    private String houseid;

    @XmlElement
    private boolean succeed;

    public VentSwitch(String houseid) {
        this.houseid = houseid;
        status = "off";
        succeed = true;
    }

    public String getHouseid() {
        return houseid;
    }

    public String getStatus() {
        return status;
    }

    public void ventOn() {
        status = "on";
    }

    public void ventOff() {
        status = "off";
    }
}
