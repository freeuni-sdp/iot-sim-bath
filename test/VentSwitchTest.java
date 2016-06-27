
import ge.edu.freeuni.sdp.iot.simulator.bath.jaxb.VentSwitchPostRequest;
import ge.edu.freeuni.sdp.iot.simulator.bath.service.BathroomService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;


import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;


public class VentSwitchTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(BathroomService.class);
    }

    @Test
    public void testAddMeasurement(){

        VentSwitchPostRequest ventSwitchPostRequest = new VentSwitchPostRequest();
        ventSwitchPostRequest.setStatus("ON");
        Entity<VentSwitchPostRequest> switchEntity = Entity.entity(ventSwitchPostRequest,
                                                    MediaType.APPLICATION_JSON);
        Response response = target("bath/vent-switch").request(MediaType.APPLICATION_JSON)
                .post(switchEntity, Response.class);
//        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
    }
}