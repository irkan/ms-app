package az.kapitalbank.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientApplication {

    @Value("${data.key}")
    private String pseudoProperty;

    @Value("${data.key2}")
    private String pseudoProperty2;

    @GetMapping("/property")
    public ResponseEntity<String> getProperty() {
        return ResponseEntity.ok(pseudoProperty);
    }

    @GetMapping("/property2")
    public ResponseEntity<String> getProperty2() {
        return ResponseEntity.ok(pseudoProperty2);
    }
}
