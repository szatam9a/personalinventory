package demo.personalinventory.contact;

import demo.personalinventory.address.Address;
import demo.personalinventory.address.AddressNotFoundException;
import demo.personalinventory.address.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactService {
    private ContactRepository contactRepository;
    private AddressRepository addressRepository;

    public Contact findContactById(long id) {
        return contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
    }

    public Contact createContact(CreateContactCommand createContactCommand) {
        Address address = addressRepository.findById(createContactCommand.getAddressId()).orElseThrow(
                () -> new AddressNotFoundException(createContactCommand.getAddressId()));
        Contact contact = new Contact();
        contact.setAddress(address);
        contact.setPhoneNumber(createContactCommand.getPhoneNumber());
        contact.setEmailAddress(createContactCommand.getEmailAddress());
        return contactRepository.save(contact);
    }
}
