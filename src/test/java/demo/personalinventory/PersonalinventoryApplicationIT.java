package demo.personalinventory;

import demo.personalinventory.person.CreatePersonCommand;
import demo.personalinventory.person.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Sql(statements = {"delete from persons", "delete from contacts", "delete from addresses"})
class PersonalinventoryApplicationIT {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreatePerson() {
        webTestClient.post()
                .uri("/api/person")
                .bodyValue(new CreatePersonCommand("Joe"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Person.class)
                .returnResult()
                .getResponseBody()
                .getName().equals("Joe");
    }
    @Test
    void testGetAllPerson() {
        assertTrue(webTestClient.get()
                .uri("/api/person")
                .exchange()
                .expectBodyList(Person.class)
                .returnResult()
                .getResponseBody().get(0)
                .getTemporaryAddress().getContactList().size() == 1);
    }
}
