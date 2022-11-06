package demo.personalinventory.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactCommand {

    private Long addressId;
    private String emailAddress;
    private String phoneNumber;
}
