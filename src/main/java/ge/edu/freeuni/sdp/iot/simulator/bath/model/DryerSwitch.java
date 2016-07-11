package ge.edu.freeuni.sdp.iot.simulator.bath.model;

/**
 * Created by Giorgi on 27-Jun-16.
 */
public class DryerSwitch {

    private boolean isOn;
    private String houseId;

    public DryerSwitch(String houseId){
        this.houseId = houseId;
    }

    public boolean isOn() {
        return isOn;
    }

    public void set(boolean on) {
        isOn = on;
    }
}
