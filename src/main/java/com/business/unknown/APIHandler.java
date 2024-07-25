package com.business.unknown;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.business.unknown.utils.HtmlConverter;
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
import java.time.LocalDate;

public class APIHandler implements RequestStreamHandler {

    private static final Logger logger = LoggerFactory.getLogger(APIHandler.class);
    private JSONParser parser = new JSONParser();

    private HtmlConverter htmlConverter = new HtmlConverter();
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();
        try {
            JSONObject event = (JSONObject) parser.parse(reader);

            String bodyResponse = "<h1>NO RESPONSE</h1>";

            if (event.get("body") != null) {
                logger.info("BODY: "+event.get("body").toString());
                org.thymeleaf.context.Context ctx = new org.thymeleaf.context.Context();
                ctx.setVariable("name", event.get("body").toString());
                ctx.setVariable("date", LocalDate.now().toString());
                htmlConverter.buildHtml(ctx);
            }
            JSONObject headerJson = new JSONObject();
            headerJson.put("Content-Type", "text/html; charset=UTF-8");

            responseJson.put("statusCode", 200);
            responseJson.put("headers", headerJson);
            responseJson.put("body", bodyResponse);

        } catch (ParseException pex) {
            responseJson.put("statusCode", 400);
            responseJson.put("exception", pex);
        }

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
    }
}
