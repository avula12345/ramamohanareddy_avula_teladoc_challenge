package com.rest.runner.Utilities;

import io.restassured.RestAssured;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

public class RestProcessor {

    /*
     * Supported Request Methods are POST, PUT, GET, DELETE.
     *
     * */
    public HttpURLConnection processRestCall(Map<String, String> inputMap) throws Throwable {
        String requestMethod = inputMap.get("RequestMethod").toUpperCase();
        String[] supportedAPIMethod = {"POST", "PUT", "GET", "DELETE"};
        if (!Arrays.asList(supportedAPIMethod).contains(requestMethod)) {
            throw new Exception("Unsupported API Method");
        }
        RestAssured.baseURI = inputMap.get("URL") + inputMap.get("Path");
        System.out.println("URL = " + RestAssured.baseURI);

        HttpURLConnection httpURLConnection = null;
        if (requestMethod.equalsIgnoreCase("GET")) {
            URL url = new URL(RestAssured.baseURI);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(requestMethod);
        }
        return httpURLConnection;
    }
}
