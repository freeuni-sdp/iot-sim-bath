package ge.edu.freeuni.sdp.iot.simulator.bath.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LightSwitchPostRequest {
    @XmlElement
    public String status;
}
