package ge.edu.freeuni.sdp.iot.simulator.bath.model;

public class Bathroom {

    private String houseId;
    private LightSwitch lightSwitch;
    private HumiditySensor humiditySensor;
    private VentSwitch ventSwitch;

    public Bathroom(String houseId, LightSwitch lightSwitch,
                    HumiditySensor humiditySensor, VentSwitch ventSwitch) {
        this.houseId = houseId;
        this.lightSwitch = lightSwitch;
        this.humiditySensor = humiditySensor;
        this.ventSwitch = ventSwitch;
    }

    public void turnLightOn() {
        lightSwitch.lightOn(houseId);
        humiditySensor.increaseHumidity(houseId);
    }

    public void turnLightOff() {
        lightSwitch.lightOff(houseId);
    }

    public void turnVentOn() {
        ventSwitch.ventOn();
        humiditySensor.decreaseHumidity(houseId);
    }

    public void turnVentOff() {
        ventSwitch.ventOff();
    }
}
