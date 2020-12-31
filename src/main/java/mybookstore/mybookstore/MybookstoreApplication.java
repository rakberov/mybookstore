package mybookstore.mybookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class MybookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybookstoreApplication.class, args);
        System.out.println("Well done, bro");
    }


}
