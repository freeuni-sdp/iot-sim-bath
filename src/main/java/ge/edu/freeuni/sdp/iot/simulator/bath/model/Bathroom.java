package ge.edu.freeuni.sdp.iot.simulator.bath.model;

public class Bathroom {

    private static Bathroom instance;
    public static String TEST_HOUSE_ID = "a1bc00fb-4724-476a-a553-d65d2c1bac0e";

    public static Bathroom getInstance() {
        if (instance == null) {
            instance = new Bathroom();
            instance.setLightSwitch(new LightSwitch(TEST_HOUSE_ID));
            instance.setHumiditySensor(new HumiditySensor(TEST_HOUSE_ID));
            instance.setVentSwitch(new VentSwitch(TEST_HOUSE_ID));
        }
        return instance;
    }

    private LightSwitch lightSwitch;
    private HumiditySensor humiditySensor;
    private VentSwitch ventSwitch;

    private Bathroom() {
        
    }

    private void setHumiditySensor(HumiditySensor humiditySensor) {
        this.humiditySensor = humiditySensor;
    }

    private void setLightSwitch(LightSwitch lightSwitch) {
        this.lightSwitch = lightSwitch;
    }

    private void setVentSwitch(VentSwitch ventSwitch) {
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

    public VentSwitch getVentSwitch() {
        return ventSwitch;
    }
}
