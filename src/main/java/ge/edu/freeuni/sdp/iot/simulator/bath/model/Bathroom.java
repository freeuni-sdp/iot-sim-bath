package ge.edu.freeuni.sdp.iot.simulator.bath.model;

public class Bathroom {

    public static Bathroom instance;
    public static String TEST_HOUSE_ID = "a1bc00fb-4724-476a-a553-d65d2c1bac0e";

    public static Bathroom getInstance() {
        if (Bathroom.instance == null) {
            Bathroom.instance = new Bathroom();
            Bathroom.instance.setLightSwitch(new LightSwitch(TEST_HOUSE_ID));
            Bathroom.instance.setVentSwitch(new VentSwitch(TEST_HOUSE_ID));
            Bathroom.instance.setDryerSwitch(new DryerSwitch(TEST_HOUSE_ID));

            Bathroom.instance.setHumiditySensor(new HumiditySensor(TEST_HOUSE_ID,
                     instance.getLightSwitch(),
                     instance.getVentSwitch(),
                     instance.getDryerSwitch()));
        }
        return Bathroom.instance;
    }

    private LightSwitch lightSwitch;
    private HumiditySensor humiditySensor;
    private VentSwitch ventSwitch;
    private DryerSwitch dryerSwitch;

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

    private void setDryerSwitch(DryerSwitch dryerSwitch) {
        this.dryerSwitch = dryerSwitch;
    }

    public void turnLightOn() {
        lightSwitch.lightOn();
    }

    public void turnLightOff() {
        lightSwitch.lightOff();
    }

    public void turnVentOn() {
        ventSwitch.ventOn();
    }

    public void turnVentOff() {
        ventSwitch.ventOff();
    }

    public void turnDryerOn(){
        dryerSwitch.set(true);
    }

    public void turnDryerOff(){
        dryerSwitch.set(false);
    }

    public VentSwitch getVentSwitch() {
        return ventSwitch;
    }

    public LightSwitch getLightSwitch(){
        return lightSwitch;
    }

    public DryerSwitch getDryerSwitch() {
        return dryerSwitch;
    }
}
