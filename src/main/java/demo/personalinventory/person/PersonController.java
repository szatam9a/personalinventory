package demo.personalinventory.person;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/person")
@AllArgsConstructor
public class PersonController {
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }
    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable Long id){
        return personService.findPersonById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createNewPerson(@RequestBody CreatePersonCommand createPersonCommand) {
        return personService.createNewPerson(createPersonCommand);
    }

    @PutMapping
    public Person updatePerson(@Valid @RequestBody UpdatePersonCommand updatePersonCommand) {
        return personService.updatePerson(updatePersonCommand);
    }
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id ){
        personService.deletePersonById(id);
    }
}
