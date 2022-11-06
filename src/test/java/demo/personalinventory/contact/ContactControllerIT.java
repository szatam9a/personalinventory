package demo.personalinventory.contact;

import demo.personalinventory.address.Address;
import demo.personalinventory.address.CreateAddressCommand;
import demo.personalinventory.person.CreatePersonCommand;
import demo.personalinventory.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Sql(statements = {"delete from persons", "delete from contacts", "delete from addresses"})

class ContactControllerIT {

    @Autowired
    WebTestClient webTestClient;
    Person person;
    Address address;
    Contact contact;
    @BeforeEach
    void createPersonContactAddressTest() {
         person = webTestClient.post().uri("api/person")
                .bodyValue(new CreatePersonCommand("Joe"))
                .exchange()
                .expectBody(Person.class)
                .returnResult()
                .getResponseBody();
        address =webTestClient.post().uri("api/address/temp")
                .bodyValue(new CreateAddressCommand(person.getId(),"Joe","Jack"))
                .exchange()
                .expectBody(Address.class)
                .returnResult()
                .getResponseBody();
        contact = webTestClient.post().uri("api/contact")
                .bodyValue(new CreateContactCommand(address.getId(),"Some","Other"))
                .exchange()
                .expectBody(Contact.class)
                .returnResult()
                .getResponseBody();
    }
    @Test
    void contactUpdateTest(){
        Contact updatedContact = webTestClient.put().uri("api/contact")
                .bodyValue(new UpdateContactCommand(contact.getId(), "0620666666","emailAddress"))
                .exchange()
                .expectBody(Contact.class)
                .returnResult()
                .getResponseBody();
        assertThat(updatedContact).extracting(e->e.getPhoneNumber()).isEqualTo("0620666666");
    }
}