package cl.cummins.mgdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MgdiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MgdiApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("cristian.reyesf@cummins.cl"));
    }

    // Creating a bean for password encryption
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
