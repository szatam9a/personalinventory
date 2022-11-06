package demo.personalinventory.address;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/address")
@AllArgsConstructor
public class AddressController {
    private AddressService addressService;

    @GetMapping("/{id}")
    public Address getAddressById(@RequestParam Long id) {
        return addressService.findAddressById(id);
    }
    @PostMapping("temp")
    public  Address createTempAddressForPerson(@RequestBody CreateAddressCommand createAddressCommand){
        return addressService.createTempAddress(createAddressCommand);
    }
    @PostMapping("/perm")
    public  Address createPermAddressForPerson(@RequestBody CreateAddressCommand createAddressCommand){
        return addressService.createPermAddress(createAddressCommand);
    }
    @PutMapping
    public Address updateAddressById(@RequestBody UpdateAddressCommand updateAddressCommand){
        return addressService.updateAddress(updateAddressCommand);
    }
}
