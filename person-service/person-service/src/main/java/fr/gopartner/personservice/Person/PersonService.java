package fr.gopartner.personservice.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> retrieveAllpersons() {
        return personRepository.findAll();
    }

    @Override
    public Person addPerson(Person s) {
        return personRepository.save(s);
    }

    @Override
    public Person updatePerson(Person u) {
        return personRepository.save(u);
    }

    @Override
    public Optional<Person> retrievePerson(int id) {
        return personRepository.findById(id);
    }

    @Override
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }
}
