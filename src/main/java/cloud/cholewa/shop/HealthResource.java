package cloud.cholewa.shop;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/health")
public class HealthResource {

    @GET
//    @Produces("text/plain")
    public String hello() {
        return "it works!";
    }
}
