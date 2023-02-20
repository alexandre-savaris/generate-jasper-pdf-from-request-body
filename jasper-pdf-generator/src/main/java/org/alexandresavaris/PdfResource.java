package org.alexandresavaris;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.alexandresavaris.beans.JsonRootBean;
import io.vertx.core.json.JsonObject;

@Path("/pdf")
public class PdfResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String get(JsonObject jsonObject) {

        // Mapping the JSON received on request body to JavaBeans.
        JsonRootBean jsonRootBean = jsonObject.mapTo(JsonRootBean.class);
        //List<Prizes> prizes = jsonRootBean.getPrizes();
        //Prizes prize = prizes.get(0);
        //return "" + prize.getLaureates().size();
        return "" + jsonRootBean.getPrizes().size();
    }
}
