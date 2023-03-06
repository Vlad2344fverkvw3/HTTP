package Task2;

import java.net.URI;

import static Task2.Task2.lastLastPostCommentIdCo;
import static Task2.Task2.lastPostId;

public class task2Test {
        public static void main(String[] args) throws Exception {
            Task2 task2HTTP = new Task2();
            Integer num = lastPostId(URI.create("https://jsonplaceholder.typicode.com/users/1/posts"));
            Integer postNum = lastLastPostCommentIdCo(num);
            task2HTTP.sendPostbyId(num, postNum);
        }

}
