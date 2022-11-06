package demo.personalinventory.address;

import demo.personalinventory.person.Person;
import demo.personalinventory.person.PersonNotFoundException;
import demo.personalinventory.person.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class AddressService {
    private AddressRepository addressRepository;
    private PersonRepository personRepository;

    public Address findAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(
                () -> new AddressNotFoundException(id)
        );
    }

    @Transactional
    public Address createTempAddress(CreateAddressCommand createAddressCommand) {
        Person person = personRepository.findById(createAddressCommand.getPersonId()).orElseThrow(
                () -> new PersonNotFoundException(createAddressCommand.getPersonId()));
        Address address = new Address();
        addressRepository.save(address);
        address.setCity(createAddressCommand.getCity());
        address.setStreet(createAddressCommand.getStreet());
        person.setTemporaryAddress(address);
        return address;
    }

    @Transactional
    public Address createPermAddress(CreateAddressCommand createAddressCommand) {
        Person person = personRepository.findById(createAddressCommand.getPersonId()).orElseThrow(
                () -> new PersonNotFoundException(createAddressCommand.getPersonId()));
        Address address = new Address();
        address.setCity(createAddressCommand.getCity());
        address.setStreet(createAddressCommand.getStreet());
        person.setPermanentAddress(address);
        return addressRepository.save(address);
    }

    @Transactional
    public Address updateAddress(UpdateAddressCommand updateAddressCommand) {
        Address address = addressRepository.findById(updateAddressCommand.getId()).orElseThrow(
                () -> new AddressNotFoundException(updateAddressCommand.getId()));
        address.setStreet(updateAddressCommand.getStreet());
        address.setCity(updateAddressCommand.getCity());
        return address;
    }
}
