import ge.edu.freeuni.sdp.iot.simulator.bath.model.LightSwitch;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.validation.OverridesAttribute;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;

public class LightSwitchTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(LightSwitch.class);
    }

    @Test
    public void testAddMeasurement(){
        LightSwitch switch1 = new LightSwitch("8");
        Entity<LightSwitch> switchEntity = Entity.entity(switch1, MediaType.APPLICATION_JSON);
        Response response = target("house/8").request(MediaType.APPLICATION_JSON).header("Origin", "http://localhost:8080")
                .post(switchEntity, Response.class);
        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
    }
}
