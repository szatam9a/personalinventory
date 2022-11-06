package demo.personalinventory.contact;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class ContactNotFoundException extends AbstractThrowableProblem {
    public ContactNotFoundException(long id) {
        super(URI.create("contact/contact-not-found"),
                "Contact not found",
                Status.NOT_FOUND,
                String.format("Contact not found with id: %d", id));
    }
}