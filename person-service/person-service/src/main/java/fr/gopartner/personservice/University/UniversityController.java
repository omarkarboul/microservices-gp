package fr.gopartner.personservice.University;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("person")
public class UniversityController {

    @Autowired
    IUniversityService universityService;

    @GetMapping("/retrieve-all-universities")
    @ResponseBody
    public List<University> getUniversities() {
        return universityService.retrieveAlluniversities();
    }

    @GetMapping("/retrieve-university/{university-id}")
    @ResponseBody
    public Optional<University> retrieveUniversity(@PathVariable("university-id") int universityId) {
        return universityService.retrieveUniversity(universityId);
    }

    @PostMapping("/add-university")
    @ResponseBody
    public University addUniversity(@RequestBody University c) {
        return universityService.addUniversity(c);
    }

    @DeleteMapping("/remove-university/{university-id}")
    public void removeUniversity(@PathVariable("university-id") int universityId) {
        universityService.deleteUniversity(universityId);
    }

    @PutMapping("/update-university")
    @ResponseBody
    public University modifyUniversity(@RequestBody University university) {
        return universityService.updateUniversity(university);
    }
}
