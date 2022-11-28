package com.example.BestMealsWeb.HTTP;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class Request {

    private HttpClient client = HttpClient.newHttpClient();
    private java.net.http.HttpRequest request;

    public Request(java.net.http.HttpRequest request) {
        this.request = request;
    }

    public HttpResponse<String> requisitar() throws IOException, InterruptedException {
        return this.client.send( this.request,HttpResponse.BodyHandlers.ofString() );
    }
}
