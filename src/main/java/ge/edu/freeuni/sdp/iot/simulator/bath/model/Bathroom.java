package ge.edu.freeuni.sdp.iot.simulator.bath.model;

public class Bathroom {

    private LightSwitch lightSwitch;
    private HumiditySensor humiditySensor;
    private VentSwitch ventSwitch;

    public Bathroom(LightSwitch lightSwitch, HumiditySensor humiditySensor, VentSwitch ventSwitch) {
        this.lightSwitch = lightSwitch;
        this.humiditySensor = humiditySensor;
        this.ventSwitch = ventSwitch;
    }

    public void turnLightOn() {
        lightSwitch.lightOn();
        humiditySensor.increaseHumidity();
    }

    public void turnLightOff() {
        lightSwitch.lightOff();
    }

    public void turnVentOn() {
        ventSwitch.ventOn();
        humiditySensor.decreaseHumidity();
    }

    public void turnVentOff() {
        ventSwitch.ventOff();
    }

    public String getStatus() {
        return ventSwitch.getStatus();
    }
}
