package demo.personalinventory.address;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class AddressNotFoundException extends AbstractThrowableProblem {
    public AddressNotFoundException(long id) {
        super(URI.create("address/address-not-found"),
                "Address not found",
                Status.NOT_FOUND,
                String.format("Address not found with id: %d", id));
    }
}