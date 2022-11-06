package demo.personalinventory.address;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/address")
@AllArgsConstructor
public class AddressController {
    private AddressService addressService;

    @GetMapping("/{id}")
    public Address getAddressById(@RequestParam Long id) {
        return addressService.findAddressById(id);
    }
}
