package ge.edu.freeuni.sdp.iot.simulator.bath.model;

/**
 * Created by Babalah on 6/24/2016.
 */
public class Human {

    public static void EnterBath(String houseId) {
        LightSwitch.on(houseId);
        //TODO increase humidity
    }

    public static void LeaveBath(String houseId) {
        LightSwitch.off(houseId);
        //TODO decrease humidity or do what you want
    }
}
