package demo.personalinventory.contact;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
@AllArgsConstructor
public class ContactController {
    private ContactRepository contactRepository;

    @GetMapping("/{id}")
    public Contact findContactById(@PathVariable long id) {
        return contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
    }
}
