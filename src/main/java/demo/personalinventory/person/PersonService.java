package demo.personalinventory.person;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public Person updatePerson(UpdatePersonCommand updatePersonCommand) {
        Person person = personRepository.findById(updatePersonCommand.getPersonId()).orElseThrow(
                () -> new PersonNotFoundException(updatePersonCommand.getPersonId()));
        person.setName(updatePersonCommand.getPersonName());
        return person;
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    public Person findPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
}
