package ge.edu.freeuni.sdp.todo.core;

/**
 * Created by Babalah on 6/24/2016.
 */
public class House {
    public int id;
    public Human [] hosts;
    public LightSwitch lightSwitch;

    public House(int id) {
        this.id = id;
        lightSwitch = new LightSwitch(id);
    }

    public void populate(int n) {
        hosts = new Human[n];
        for (int i = 0; i < n; i++) {
            Human human = new Human(this, i);
            hosts[i] = human;
        }
    }
}
