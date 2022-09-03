package cl.cummins.mgdi.integrationtest;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;

public class MgdiApplicationTestIT {

    @Test
    void contextLoads(){
        System.out.println("Integreation Test running");
    }
}
