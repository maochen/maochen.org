package org.maochen;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class WebService {

    // @Path("/{order}")
    // @PUT
    // @Produces("text/html")
    // public String create(@PathParam("order") String order, @QueryParam("customer_name") String
    // customerName) {
    //
    // return "Added order #" + order;
    // }

    @GET
    @Produces("text/html")
    public String find(@PathParam("name") final String name) {
        String returnStr = "Jersey REST WebSerivce Started";
        if (name != null && !name.trim().isEmpty()) returnStr += " for" + name;
        return returnStr;
    }

}
