package Task1;
import java.io.IOException;
import java.net.URISyntaxException;
public class Task1Test {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Task1 task1HTTP = new Task1();
        User user = new User(1, "Leanne Graham", "Bret", "Sincere@april.biz",
                new Address("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874",
                        new Geo("-37.3159", "81.1496")),
                "1-770-736-8031 x56442", "hildegard.org",
                new Company("Romaguera-Crona", "Multi-layered client-server neural-net", "harness real-time e-markets")
        );
        task1HTTP.postUrl(user);
        task1HTTP.sendPut(user);
        task1HTTP.sendDelete(1);
        task1HTTP.sendGet();
        task1HTTP.sendGetById(1);
        task1HTTP.sendGetByUserName("Bret");
    }
}
