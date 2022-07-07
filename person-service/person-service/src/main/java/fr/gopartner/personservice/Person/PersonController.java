package fr.gopartner.personservice.Person;

import fr.gopartner.personservice.Client.Car;
import fr.gopartner.personservice.Client.CarServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    IPersonService PersonService;

    @Autowired
    private CarServiceClient carServiceClient;


    @GetMapping("/get-cars/{person-id}")
    @ResponseBody
    public List<Car> getCars(@PathVariable("person-id") int personId) {
        return carServiceClient.getCars(personId);
    }

    @GetMapping("/retrieve-all-persons")
    @ResponseBody
    public List<Person> getPersons() {
        return PersonService.retrieveAllpersons();
    }

    @GetMapping("/retrieve-person/{person-id}")
    @ResponseBody
    public Optional<Person> retrievePerson(@PathVariable("person-id") int personId) {
        return PersonService.retrievePerson(personId);
    }

    @PostMapping("/add-person")
    @ResponseBody
    public Person addPerson(@RequestBody Person c) {
        return PersonService.addPerson(c);
    }

    @DeleteMapping("/remove-person/{person-id}")
    public void removePerson(@PathVariable("person-id") int personId) {
        PersonService.deletePerson(personId);
    }

    @PutMapping("/update-person")
    @ResponseBody
    public Person modifyPerson(@RequestBody Person person) {
        return PersonService.updatePerson(person);
    }
}
