package ge.edu.freeuni.sdp.iot.simulator.bath.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Giorgi on 27-Jun-16.
 */

@XmlRootElement
public class DryerSwitchPostRequest {

    @XmlElement
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
