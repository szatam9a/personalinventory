package demo.personalinventory.contact;

import demo.personalinventory.address.Address;
import demo.personalinventory.address.AddressNotFoundException;
import demo.personalinventory.address.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ContactService {
    private ContactRepository contactRepository;
    private AddressRepository addressRepository;

    public Contact findContactById(long id) {
        return contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
    }

    @Transactional
    public Contact createContact(CreateContactCommand createContactCommand) {
        Address address = addressRepository.findById(createContactCommand.getAddressId()).orElseThrow(
                () -> new AddressNotFoundException(createContactCommand.getAddressId()));
        Contact contact = new Contact();
        address.getContactList().add(contact);
        contactRepository.save(contact);
        contact.setAddress(address);
        contact.setPhoneNumber(createContactCommand.getPhoneNumber());
        contact.setEmailAddress(createContactCommand.getEmailAddress());
        return contact;
    }

    @Transactional
    public Contact updateContactDetails(UpdateContactCommand updateContactCommand) {
        Contact contact = contactRepository.findById(updateContactCommand.getId()).orElseThrow(
                () -> new ContactNotFoundException(updateContactCommand.getId()));
        contact.setPhoneNumber(updateContactCommand.getPhoneNumber());
        contact.setEmailAddress(updateContactCommand.getEmailAddress());
        return contact;
    }
}
