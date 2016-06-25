package ge.edu.freeuni.sdp.iot.simulator.bath.model;

/**
 * Created by khrak on 6/25/16.
 */
public class VentSwitch {
    private String status;
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
