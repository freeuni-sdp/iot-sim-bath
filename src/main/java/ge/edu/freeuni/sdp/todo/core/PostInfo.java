package ge.edu.freeuni.sdp.todo.core;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by Babalah on 6/25/2016.
 */
@Path("status") //TODO change "status" to relevant path
public class PostInfo {

    @POST
    @Consumes("application/json")
    public void post(final MyJaxBean input) {
        if (input.status == "in")
            Human.EnterBath(input.houseId);
        else if (input.status == "out")
            Human.LeaveBath(input.houseId);
    }
}
