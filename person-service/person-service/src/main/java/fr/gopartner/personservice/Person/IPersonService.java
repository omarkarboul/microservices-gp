package fr.gopartner.personservice.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService {

    List<Person> retrieveAllpersons();

    Person addPerson(Person s);

    Person updatePerson(Person u);

    Optional<Person> retrievePerson(int id);

    void deletePerson(int id);
}
