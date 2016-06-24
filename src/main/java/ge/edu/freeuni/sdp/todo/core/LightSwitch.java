package ge.edu.freeuni.sdp.todo.core;

/**
 * Created by Babalah on 6/24/2016.
 */
public class LightSwitch {
    private int houseId;
    private boolean isOn = false;

    public LightSwitch(int houseId) {
        this.houseId = houseId;
    }

    public void on() {
        isOn = true;
        //TODO send post request to https://iot-bath-light-sensor.herokuapp.com/
    }

    public void off() {
        isOn = false;
        //TODO send post request to https://iot-bath-light-sensor.herokuapp.com/
    }

    public boolean isOn() {
        return isOn;
    }
}
