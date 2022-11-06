package demo.personalinventory.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateContactCommand {

    private Long id;
    private String phoneNumber;
    private String emailAddress;
}
