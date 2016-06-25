package ge.edu.freeuni.sdp.iot.simulator.bath.model;

public class LightSwitch {
    private String houseId;

    public LightSwitch(String houseId) {
        this.houseId = houseId;
    }

    public void lightOn() {
        //TODO send post request to https://iot-bath-light-sensor.herokuapp.com/
    }

    public void lightOff() {
        //TODO send post request to https://iot-bath-light-sensor.herokuapp.com/
    }
}
