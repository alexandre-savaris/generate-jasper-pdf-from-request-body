package org.alexandresavaris;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.alexandresavaris.beans.JsonRootBean;
import io.vertx.core.json.JsonObject;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRSaver;

@Path("/pdf")
public class PdfResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response get(JsonObject jsonObject) {

        // The PDF content to be returned to the client.
        byte[] pdfContent = null;

        // Mapping the JSON received on request body to JavaBeans.
        JsonRootBean jsonRootBean = jsonObject.mapTo(JsonRootBean.class);

        // Retrieving the JasperReports template.
        try (InputStream jasperStream = getClass().getResourceAsStream("/nobel.jrxml")) {

            // Compiling the template into the .JASPER binary format.
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
            JRSaver.saveObject(jasperReport, "nobel.jasper");

            // Using the previously created JavaBeans as the report's datasource.
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(jsonRootBean.getPrizes());

            // Running the report.
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

            // Retrieving the result as PDF.
            pdfContent = JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }

        // Returning the PDF to the client through response body.
        ResponseBuilder response = Response.ok(pdfContent);
        response.header("Content-Type", "application/pdf");
        return response.build();
    }
}
