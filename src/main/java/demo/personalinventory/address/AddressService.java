package demo.personalinventory.address;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressService {
    private AddressRepository addressRepository;

    public Address findAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(
                () -> new AddressNotFoundException(id)
        );
    }
}
