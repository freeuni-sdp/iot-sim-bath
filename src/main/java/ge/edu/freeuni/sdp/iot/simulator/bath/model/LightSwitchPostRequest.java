package ge.edu.freeuni.sdp.iot.simulator.bath.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LightSwitchPostRequest {

    @XmlElement
    private String status;

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
