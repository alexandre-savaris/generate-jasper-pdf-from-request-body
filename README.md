# generate-jasper-pdf-from-request-body
A microservice developed to generate PDFs from a JasperReport template using JSON data sent through HTTP requests.

Sometimes, data needed to generate reports are not retrieved directly from databases. The content stored in JSON files, XML files, CSV files, among other data formats, can be ingested directly into report templates at runtime.

This project exemplifies the process of using a microservice exposing an endpoint to generate PDF reports. The report template prints the year, the category, the overall motivation, and nested lists of laureates who won Nobel Prizes through the years. Both the dataset file (.JSON) and the template file (.JRXML) are available as resources.

To start the microservice: `mvn quarkus:dev`

To generate the report in PDF: `POST http://localhost:8080/pdf`, passing the JSON data in the request body, with `Content-Type: application/json`.


<h3>Useful references</h3>

[QUARKUS](https://quarkus.io/)

[Jaspersoft Community](https://community.jaspersoft.com/)

[How to fill report with bean data or JSON data](https://community.tibco.com/s/question/0D54z00007mxRUHCA2/how-to-fill-report-with-bean-data-or-json-data)

[Creating Report with List containing List using Jasper Report](https://www.qualogy.com/techblog/java-web/creating-report-with-list-containing-list-using-jasper-report)
