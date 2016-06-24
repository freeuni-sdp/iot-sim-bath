package ge.edu.freeuni.sdp.todo.core;

/**
 * Created by Babalah on 6/24/2016.
 */
public class Human {
    private House house;
    private int id;

    public Human(House house, int id) {
        this.house = house;
        this.id = id;
    }

    public void EnterBath() {
        System.out.println("human #" + id + " in house #" + house.id + " enters bathroom at " + System.currentTimeMillis());
        house.lightSwitch.on();
    }

    public void LeaveBath() {
        System.out.println("human #" + id + " in house #" + house.id + " leaves bathroom at " + System.currentTimeMillis());
        house.lightSwitch.off();
    }
}
