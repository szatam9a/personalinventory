package demo.personalinventory.person;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public Person createNewPerson(@RequestBody CreatePersonCommand createPersonCommand){
     return personService.createNewPerson(createPersonCommand);
    }
}
