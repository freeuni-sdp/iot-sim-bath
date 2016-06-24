package ge.edu.freeuni.sdp.todo.core;

import java.util.Random;

/**
 * Created by Babalah on 6/24/2016.
 */
public class Main {
    public static final int MAX_HUMANS_PER_HOUSE = 2;
    public static final int HOUSE_NUM = 2;

    public static void main(String [] args) {
        Random rand = new Random();
        House [] houses = new House[HOUSE_NUM];
        for (int i = 0; i < HOUSE_NUM; i++) {
            House house = new House(i);
            house.populate(MAX_HUMANS_PER_HOUSE);
            houses[i] = house;
        }
        houses[0].hosts[0].EnterBath();
        try { Thread.sleep(1000); }
        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
        houses[0].hosts[0].LeaveBath();
        try { Thread.sleep(500); }
        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
        houses[1].hosts[1].EnterBath();
        try { Thread.sleep(2000); }
        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
        houses[1].hosts[0].EnterBath();
        try { Thread.sleep(2000); }
        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
        houses[1].hosts[0].LeaveBath();
        try { Thread.sleep(1000); }
        catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
        houses[1].hosts[1].LeaveBath();
    }
}
