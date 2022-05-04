package com.rest.runner.StepDefinitions.API;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.rest.runner.Utilities.RestProcessor;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.*;

public class BaseHook {
    Map<String, String> requestMap = new HashMap<>();
    String response=null;

    @Given("Get the API Url")
    public void getAndSetTheAPIUrl() {
        requestMap.put("URL", "https://jsonmock.hackerrank.com");
    }

    @Then("Construct the {string} request body with the following data")
    public void constructTheRequestBodyForWithTheFollowingData(String requestName, DataTable datatable) {
        requestMap.put("RequestName", requestName);
        Map<String, String> inputMap = datatable.asMap(String.class, String.class);
        requestMap.putAll(inputMap);
    }

    @Then("Make a Rest Call to {string} having query string {string} with {string} method")
    public void makeARestCallWithGETMethod(String path, String movieName, String method) throws Throwable {
        String apiCall = path + movieName;
        requestMap.put("Path", apiCall);
        requestMap.put("RequestMethod", method);
        HttpURLConnection httpURLConnection = getHttpURLConnection(requestMap);
        Store.responseObject = httpURLConnection;
    }

    @And("Verify if the status code is {string}")
    public void verifyIfTheStatusCodeIs(String statusCode) throws IOException {
        Assert.assertEquals(String.valueOf(Store.responseObject.getResponseCode()), statusCode, "Status code mismatch");
    }

    @Then("Get the no of pages from the response and sort the movie titles")
    public void getTheNoOfPagesFromTheResponseAndSortTheMovieTitles() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Store.responseObject.getInputStream()));
        while ((response = bufferedReader.readLine()) != null) {
            JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
            Store.totalPages = convertedObject.get("total_pages").getAsInt();
            System.out.println("Total No of Pages = " +Store.totalPages);
            System.out.println("*********** SORT THE MOVIE TITLES ***************************");
            sortTheMovieTitles(convertedObject);
            System.out.println("*********** SORT THE MOVIE TITLES ***************************");
        }
    }

    public HttpURLConnection getHttpURLConnection(Map<String, String> requestMap) throws Throwable {
        RestProcessor restProcessor = new RestProcessor();
        HttpURLConnection httpURLConnection = restProcessor.processRestCall(this.requestMap);
        return httpURLConnection;
    }

    @And("Get all the movies names matching with {string} in all the pages")
    public void getAllTheMoviesNamesMatchingWithInAllThePages(String movieName) throws Throwable {
        String apiPath = "/api/movies/search/?Title="+movieName;
        HttpURLConnection httpURLConnectionPage;
        for(int i=1;i<=Store.totalPages;i++){
            apiPath = apiPath+"&page="+i;
            requestMap.put("Path", apiPath);
            requestMap.put("RequestMethod", "GET");
            httpURLConnectionPage = getHttpURLConnection(requestMap);
            Assert.assertEquals(String.valueOf(httpURLConnectionPage.getResponseCode()), "200", "Status code mismatch");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnectionPage.getInputStream()));
            while ((response = bufferedReader.readLine()) != null) {
                JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
                System.out.println("*********** SORT THE MOVIE TITLES FOR PAGE = "+i+ " ***************************");
                sortTheMovieTitlesBasedOnMovieName(convertedObject,movieName);
                System.out.println("*********** SORT THE MOVIE TITLES FOR PAGE = "+i+ " ***************************");
            }
        }
    }

    public void sortTheMovieTitles(JsonObject object)  {
        List<String> titles = new ArrayList<>();
        JsonArray data = object.getAsJsonArray("data");
        for (int i = 0; i < data.size(); i++) {
            String title = data.get(i).getAsJsonObject().get("Title").getAsString();
            titles.add(title);
        }
        Collections.sort(titles);
        titles.forEach(System.out::println);
    }

    public void sortTheMovieTitlesBasedOnMovieName(JsonObject object,String movieName) {
        List<String> titles = new ArrayList<>();
        JsonArray data = object.getAsJsonArray("data");
        for (int i = 0; i < data.size(); i++) {
            String title = data.get(i).getAsJsonObject().get("Title").getAsString();
            if(title.contains(movieName)){
                titles.add(title);
            }
        }
        Collections.sort(titles);
        titles.forEach(System.out::println);
    }
}
