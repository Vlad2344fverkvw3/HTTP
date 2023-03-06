package Task1;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Task1 {
    public static final String firstNames = "Content-Type";
    public  static  final  String firstValue ="application/json";
    public void postUrl (User user) throws URISyntaxException, IOException, InterruptedException {
        String newUser = new Gson().toJson(user);
        String uri = "https://jsonplaceholder.typicode.com/users";
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .headers(firstNames,firstValue )
                .POST(HttpRequest.BodyPublishers.ofString(newUser))
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());
    }

    public void sendPut(User user) throws IOException, InterruptedException, URISyntaxException {
        String newUser = new Gson().toJson(user);
        String uri = "https://jsonplaceholder.typicode.com/users/" + user.getId();
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .headers(firstNames, firstValue)
                .PUT(HttpRequest.BodyPublishers.ofString(newUser))
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());
    }

    public void sendDelete(int id) throws IOException, InterruptedException, URISyntaxException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + id;
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))

                .headers(firstNames, firstValue)
                .DELETE()
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();



        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());
    }

    public void sendGet() throws URISyntaxException, IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/";
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))

                .headers(firstNames, firstValue)
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());
    }

    public void sendGetById(int id) throws IOException, InterruptedException, URISyntaxException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + id;
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .headers(firstNames, firstValue)
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());
        System.out.println("httpResponse.body() = " + httpResponse.body());
    }
    public void sendGetByUserName(String username) throws IOException, InterruptedException, URISyntaxException {
        String uri = "https://jsonplaceholder.typicode.com/users?username=" + username;
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .headers(firstNames, firstValue)
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());
        System.out.println("httpResponse.body() = " + httpResponse.body());
    }
}

