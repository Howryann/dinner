package cs.study.dinner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Howryann
 */
@SpringBootApplication
@ServletComponentScan
public class DinnerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DinnerApplication.class,args);
    }
}
