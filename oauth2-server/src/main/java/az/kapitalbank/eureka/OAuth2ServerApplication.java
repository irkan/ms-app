package az.kapitalbank.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
@EnableDiscoveryClient
public class OAuth2ServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class, args);
    }

}
