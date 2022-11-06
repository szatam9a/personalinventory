package demo.personalinventory;

import demo.personalinventory.person.CreatePersonCommand;
import demo.personalinventory.person.Person;
import demo.personalinventory.person.UpdatePersonCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest
//@Sql(statements = {"delete from persons", "delete from contacts", "delete from addresses"})
class PersonalinventoryApplicationIT {


    @Test
    void contextLoads() {
    }

}
