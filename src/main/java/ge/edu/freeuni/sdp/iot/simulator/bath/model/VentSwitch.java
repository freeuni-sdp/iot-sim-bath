package ge.edu.freeuni.sdp.iot.simulator.bath.model;

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
