package ge.edu.freeuni.sdp.iot.simulator.bath.model;

public class Bathroom {

    private String houseId;
    private LightSwitch lightSwitch;
    private HumiditySensor humiditySensor;

    public Bathroom(String houseId, LightSwitch lightSwitch, HumiditySensor humiditySensor) {
        this.houseId = houseId;
        this.lightSwitch = lightSwitch;
        this.humiditySensor = humiditySensor;
    }

    public void turnLightOn() {
        lightSwitch.lightOn(houseId);
        humiditySensor.increaseHumidity(houseId);
    }

    public void turnLightOff() {
        lightSwitch.lightOff(houseId);
    }

    public void turnVentOn() {
        // TODO vent reaction
        humiditySensor.decreaseHumidity(houseId);
    }

    public void turnVentOff() {
        // TODO vent reaction
    }
}
