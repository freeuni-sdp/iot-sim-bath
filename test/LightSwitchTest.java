import ge.edu.freeuni.sdp.iot.simulator.bath.model.LightSwitchPostRequest;
import ge.edu.freeuni.sdp.iot.simulator.bath.service.BathroomService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;


import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;

public class LightSwitchTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(BathroomService.class);
    }

    @Test
    public void testAddMeasurement(){

        LightSwitchPostRequest lightSwitchPostRequest = new LightSwitchPostRequest();
        lightSwitchPostRequest.setStatus("ON");
        Entity<LightSwitchPostRequest> switchEntity = Entity.entity(lightSwitchPostRequest, MediaType.APPLICATION_JSON);
        Response response = target("bath/light-switch").request(MediaType.APPLICATION_JSON)
                .post(switchEntity, Response.class);
        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
    }
}
