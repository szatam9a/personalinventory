package demo.personalinventory.contact;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@AllArgsConstructor
public class ContactController {
    private ContactService contactService;

    @GetMapping("/{id}")
    public Contact findContactById(@PathVariable long id) {
        return contactService.findContactById(id);
    }

    @PostMapping
    public Contact createContactForAddress(@RequestBody CreateContactCommand createContactCommand) {
        return contactService.createContact(createContactCommand);
    }
}
