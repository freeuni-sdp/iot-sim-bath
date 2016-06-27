package ge.edu.freeuni.sdp.iot.simulator.bath.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Babalah on 6/24/2016.
 */
@XmlRootElement
public class LightSwitchStatus {
    @XmlElement
    private String status;
    @XmlElement
    private String houseId;

    @XmlElement
    private String time;

    public String getHouseId() {
        return houseId;
    }

    public String getStatus() {
        return status;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
