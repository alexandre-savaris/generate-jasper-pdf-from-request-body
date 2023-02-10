package org.alexandresavaris;

import javax.json.Json;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pdf")
public class PdfResource {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response get() {
        return null;
    }
}
