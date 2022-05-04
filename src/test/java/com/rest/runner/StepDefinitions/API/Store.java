package com.rest.runner.StepDefinitions.API;

import java.net.HttpURLConnection;

/*
Store class is created to store Global Values if need to pass across different feature files
 */
public class Store {
    public static HttpURLConnection responseObject;
    public static int totalPages = 0;
}
