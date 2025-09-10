package mark.warren93.dev.WarriorsFootballAssociationapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class WarriorsFootballAssociationApiApplication {
    private static final Logger logger = LoggerFactory.getLogger(WarriorsFootballAssociationApiApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(WarriorsFootballAssociationApiApplication.class, args);
    }
}