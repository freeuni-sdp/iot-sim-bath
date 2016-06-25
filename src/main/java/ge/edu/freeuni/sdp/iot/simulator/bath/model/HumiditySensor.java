package ge.edu.freeuni.sdp.iot.simulator.bath.model;

import ge.edu.freeuni.sdp.iot.simulator.bath.jaxb.MeasurementPostRequest;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.*;

public class HumiditySensor {
    public static double NORMAL_HUMIDITY = 40.;
    public static long POST_PERIOD = 3;
    public static long HUMIDITY_INCREASE_PERIOD = 3;
    public static long HUMIDITY_INCREASE_RATE = 1;
    public static long HUMIDITY_DECREASE_PERIOD = 3;
    public static long HUMIDITY_DECREASE_RATE = 2;

    private String houseId;
    private double humidity;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final Runnable measurementPoster = new Runnable() {
        @Override
        public void run() {
            postMeasurement();
        }
    };

    private WebTarget target;

    public HumiditySensor(String houseId) {
        this.houseId = houseId;
        humidity = NORMAL_HUMIDITY;
        scheduler.scheduleAtFixedRate(measurementPoster, 0, POST_PERIOD, TimeUnit.SECONDS);

        target = ClientBuilder.newClient().target("http://iot-bath-humidity-sensor.herokuapp.com/webapi/houses/" + houseId);
    }

    public void increaseHumidity() {
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(HUMIDITY_INCREASE_PERIOD * 1000);
               } catch (InterruptedException ignored) {}
               if (humidity < 100) {
                   humidity += Math.max(HUMIDITY_INCREASE_RATE,100-humidity);
               } else {
                   return;
               }
           }
       }).start();
    }

    public void decreaseHumidity() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(HUMIDITY_DECREASE_PERIOD * 1000);

                } catch (InterruptedException ignored) {}
                if (humidity > NORMAL_HUMIDITY) {
                    humidity -= Math.max(HUMIDITY_DECREASE_RATE,humidity-NORMAL_HUMIDITY);
                } else {
                    return;
                }
            }
        }).start();
    }

    public void postMeasurement() {
        MeasurementPostRequest lastMeasurement = new MeasurementPostRequest();
        lastMeasurement.setMeasurement(humidity);

        target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(lastMeasurement));
    }

}
