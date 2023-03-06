package Task2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public void sendPostbyId(int num, int postNum) throws URISyntaxException, IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/posts/" + num + "/comments";
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .headers("Content-Type", "application/json")
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());
        String comment = httpResponse.body();
        try (OutputStream fis = new FileOutputStream("user-" + num + "-post-" + postNum + "-comments.json")) {
            fis.write(comment.getBytes());
            fis.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer lastPostId(URI uri) throws Exception {
        HttpRequest getAllRequest = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> getAllResponse = httpClient.send(getAllRequest, HttpResponse.BodyHandlers.ofString());

        List<Post> post = new Gson().fromJson(getAllResponse.body(), new TypeToken<List<Post>>() {
        }.getType());

        List<Integer> howmanyidies = post.stream()
                .sorted(Comparator.comparing(Post::getId).reversed())
                .map(Post::getId)
                .limit(1)
                .collect(Collectors.toList());

        int num = howmanyidies.get(0);
        return num;
    }

    public static Integer lastLastPostCommentIdCo(int num) throws Exception {
        String uri = "https://jsonplaceholder.typicode.com/posts/" + num + "/comments";
        HttpRequest getAllRequest = HttpRequest.newBuilder(new URI(uri))
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> getAllResponse = httpClient.send(getAllRequest, HttpResponse.BodyHandlers.ofString());

        List<Comment> comments = new Gson().fromJson(getAllResponse.body(), new TypeToken<List<Comment>>() {
        }.getType());

        List<Integer> numPostNumber = comments.stream()
                .sorted(Comparator.comparing(Comment::getPostId).reversed())
                .map(Comment::getPostId)
                .limit(1)
                .collect(Collectors.toList());

        int postNum = numPostNumber.get(0);
        return postNum;


    }
}
