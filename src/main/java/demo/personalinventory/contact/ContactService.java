package demo.personalinventory.contact;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactService {
    private ContactRepository contactRepository;


}
