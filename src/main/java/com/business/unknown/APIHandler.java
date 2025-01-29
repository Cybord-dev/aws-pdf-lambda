package com.business.unknown;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.business.unknown.model.FacturaCustom;
import com.business.unknown.utils.CsvService;
import com.business.unknown.utils.PDFBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

public class APIHandler implements RequestStreamHandler {

    private static final Logger logger = LoggerFactory.getLogger(APIHandler.class);
    private final JSONParser parser = new JSONParser();
    private final PDFBuilder pdfBuilder = new PDFBuilder();
    private final CsvService csvService = new CsvService();
    private final ObjectMapper objMapper = new ObjectMapper();

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();
        try {
            JSONObject event = (JSONObject) parser.parse(reader);

            Map<String, String> monedaMap = csvService.getMonedaMap();
            Map<String, String> metodoPagoMap = csvService.getMetodoPagoMap();
            Map<String, String> formaPagoMap = csvService.getFormaPagoMap();
            Map<String, String> usoCfdiMap = csvService.getUsoCfdiMap();
            Map<String, String> tipoDeComprobanteMap = csvService.getTipoDeComprobanteMap();
            Map<String, String> regimenFiscalMap = csvService.getRegimenFiscalMap();
            JSONObject body = new JSONObject();
            body.put("message", "NO PDF builded");

            if (event.get("body") != null) {
                String bodyString = event.get("body").toString();
                FacturaCustom invoice = objMapper.readValue(bodyString, FacturaCustom.class);
                org.thymeleaf.context.Context ctx = new org.thymeleaf.context.Context();
                ctx.setVariable("invoice", invoice);
                ctx.setVariable("invoice", invoice);
                ctx.setVariable("monedaMap", monedaMap);
                ctx.setVariable("metodoPagoMap", metodoPagoMap);
                ctx.setVariable("formaPagoMap", formaPagoMap);
                ctx.setVariable("usoCfdiMap", usoCfdiMap);
                ctx.setVariable("tipoDeComprobanteMap", tipoDeComprobanteMap);
                ctx.setVariable("regimenFiscalMap", regimenFiscalMap);
                String template = invoice.getTipoDocumento().toLowerCase();
                body.put("pdf", new String(Base64.getEncoder().encode(pdfBuilder.buildPdf(ctx, template))));
                body.put("message", "base64 PDF generated");
            }

            System.out.println("staring JSON response creation");
            JSONObject headerJson = new JSONObject();
            headerJson.put("Content-Type", "application/json");
            responseJson.put("statusCode", 200);
            responseJson.put("headers", headerJson);
            String bodyString = body.toJSONString();
            responseJson.put("body", bodyString);
            System.out.println("body created" + bodyString);

        } catch (ParseException pex) {
            responseJson.put("statusCode", 400);
            responseJson.put("exception", pex);
            System.err.println("Error parsing JSON: " + pex.getMessage());
        } catch (IOException ex) {
            responseJson.put("statusCode", 500);
            responseJson.put("exception", ex);
            System.err.println("Error reading the input stream: " + ex.getMessage());
        } catch (Exception ex) {
            responseJson.put("statusCode", 500);
            responseJson.put("exception", ex);
            System.err.println("Error processing the request: " + ex.getMessage());
        }

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        writer.write(responseJson.toString());
        writer.close();
    }
}
