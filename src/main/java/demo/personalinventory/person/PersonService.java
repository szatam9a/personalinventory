package demo.personalinventory.person;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PersonService {
    private PersonRepository personRepository;

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public Person createNewPerson(CreatePersonCommand createPersonCommand) {
        Person person = new Person();
        person.setName(createPersonCommand.getName());
        return personRepository.save(person);
    }
}
