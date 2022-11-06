package demo.personalinventory.person;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/person")
@AllArgsConstructor
public class PersonController {
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }
}
