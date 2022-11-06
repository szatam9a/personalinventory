package demo.personalinventory.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressCommand {
    private Long id;
    private String city;
    private String street;
}
