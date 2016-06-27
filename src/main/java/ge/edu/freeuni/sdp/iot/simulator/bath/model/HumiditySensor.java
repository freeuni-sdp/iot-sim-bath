package ge.edu.freeuni.sdp.iot.simulator.bath.model;

import ge.edu.freeuni.sdp.iot.simulator.bath.jaxb.MeasurementPostRequest;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.*;

public class HumiditySensor {

    private static final String URI = "http://iot-bath-humidity-sensor.herokuapp.com/webapi/houses/";

    private static final double NORMAL_HUMIDITY = 40.;
    private static final double MINIMUM_HUMIDITY = 15.;
    private static final double MAXIMUM_HUMIDITY = 100.;
    private static final double VENT_POWER = 0.5; //while vent is on, humidity decreases 0.4% per second
    private static final double LIGHT_POWER = 0.1; //while light is on, humidity increases 0.1% per second
    private static final double DRYER_POWER = 0.1; //while dryer is on, humidity increases 0.1% per second

    private static final long POST_PERIOD = 3;

    private String houseId;
    private double humidity;

    private LightSwitch lightSwitch;
    private VentSwitch ventSwitch;
    private DryerSwitch dryerSwitch;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Runnable measurementPoster = new Runnable() {
        @Override
        public void run() {
            postMeasurement();
        }
    };

    public HumiditySensor(String houseId, LightSwitch lightSwitch, VentSwitch ventSwitch, DryerSwitch dryerSwitch) {
        this.houseId = houseId;
        humidity = NORMAL_HUMIDITY;
        scheduler.scheduleAtFixedRate(measurementPoster, 0, POST_PERIOD, TimeUnit.SECONDS);
        this.houseId = houseId;

        this.lightSwitch = lightSwitch;
        this.ventSwitch = ventSwitch;
        this.dryerSwitch = dryerSwitch;
    }

    private void postMeasurement() {
        updateHumidity();
        MeasurementPostRequest lastMeasurement = new MeasurementPostRequest();
        lastMeasurement.setHumidity(humidity);

        WebTarget target = ClientBuilder.newClient().target(URI + houseId);

        Entity<MeasurementPostRequest> measurementEntity = Entity.entity(lastMeasurement, MediaType.APPLICATION_JSON);
        target.request(MediaType.APPLICATION_JSON).post(measurementEntity);
    }

    private void updateHumidity(){
        if (ventSwitch.getStatus() == "on" && humidity > MINIMUM_HUMIDITY){
            humidity -= VENT_POWER*POST_PERIOD;
        }
        if (lightSwitch.isSwitchOn() && humidity < MAXIMUM_HUMIDITY){
            humidity += LIGHT_POWER*POST_PERIOD;
        }
        if (dryerSwitch.isOn() && humidity < MAXIMUM_HUMIDITY){
            humidity += DRYER_POWER*POST_PERIOD;
        }
    }
}
