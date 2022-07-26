package cl.cummins.mgdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MgdiApplication {
    //private static final Logger logger = LoggerFactory.getLogger(MgdiApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(MgdiApplication.class, args);
        //logger.info(new BCryptPasswordEncoder().encode("cristian.reyesf@cummins.cl"));
    }

    // Creating a bean for password encryption
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
