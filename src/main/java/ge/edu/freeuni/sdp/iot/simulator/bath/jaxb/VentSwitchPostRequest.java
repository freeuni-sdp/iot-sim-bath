package ge.edu.freeuni.sdp.iot.simulator.bath.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by mi.maghriani on 6/25/2016.
 */
@XmlRootElement
public class VentSwitchPostRequest {
    @XmlElement
    public String status;
}
