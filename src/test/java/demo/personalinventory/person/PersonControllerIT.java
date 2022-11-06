package demo.personalinventory.person;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerIT {

    @Autowired
    WebTestClient webTestClient;

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