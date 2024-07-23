package com.business.unknown;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
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

public class APIHandler implements RequestStreamHandler {

    private static final Logger logger = LoggerFactory.getLogger(APIHandler.class);
    private JSONParser parser = new JSONParser();
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();
        try {
            JSONObject event = (JSONObject) parser.parse(reader);

            if (event.get("body") != null) {
                logger.info("BODY: "+event.get("body").toString());
            }

            JSONObject responseBody = new JSONObject();
            responseBody.put("message", "Automatic deploy with github actions");
            responseBody.put("change", "example deploy change");

            JSONObject headerJson = new JSONObject();
            headerJson.put("test", " my test header");

            responseJson.put("statusCode", 200);
            responseJson.put("headers", headerJson);
            responseJson.put("body", responseBody.toString());

        } catch (ParseException pex) {
            responseJson.put("statusCode", 400);
            responseJson.put("exception", pex);
        }

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
    }
}
