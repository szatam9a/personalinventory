package demo.personalinventory.person;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class PersonNotFoundException extends AbstractThrowableProblem {
    public PersonNotFoundException(long id) {
        super(URI.create("person/email-not-found"),
                "Person not found",
                Status.NOT_FOUND,
                String.format("Person not found with id: %d", id));
    }
}