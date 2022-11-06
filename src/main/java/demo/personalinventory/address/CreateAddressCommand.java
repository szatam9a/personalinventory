package demo.personalinventory.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressCommand {
    private Long personId;
    private String city;
    private String street;
}
