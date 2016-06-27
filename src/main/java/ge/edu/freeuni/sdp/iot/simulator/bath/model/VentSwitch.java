package ge.edu.freeuni.sdp.iot.simulator.bath.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by khrak on 6/25/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VentSwitch {
    @JsonProperty("status")
    private String status;

    @JsonProperty("houseid")
    private String houseid;

    public VentSwitch(String houseid) {
        this.houseid = houseid;
        status = "off";
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
