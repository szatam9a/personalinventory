package demo.personalinventory;

import demo.personalinventory.person.CreatePersonCommand;
import demo.personalinventory.person.Person;
import demo.personalinventory.person.UpdatePersonCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        String name = webTestClient.post()
                .uri("/api/person")
                .bodyValue(new CreatePersonCommand("Joe"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Person.class)
                .returnResult()
                .getResponseBody()
                .getName();
        assertThat(name).isEqualTo("Joe");
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

    @Test
    void testPersonUpdate() {
        Person personToUpdate = webTestClient.post()
                .uri("/api/person")
                .bodyValue(new CreatePersonCommand("Joe"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Person.class)
                .returnResult()
                .getResponseBody();
        Person personUpdated = webTestClient.put().uri("api/person")
                .bodyValue(new UpdatePersonCommand(personToUpdate.getId(), "James"))
                .exchange().expectBody(Person.class)
                .returnResult().getResponseBody();
        assertEquals(personUpdated.getName(), "James");


    }
}
