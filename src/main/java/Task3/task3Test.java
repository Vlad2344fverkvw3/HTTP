package Task3;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
public class task3Test {
        public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String toJson = gson.toJson(Task3Program.sendGetById(1));
            System.out.println("toJson = " + toJson);

    }
}
