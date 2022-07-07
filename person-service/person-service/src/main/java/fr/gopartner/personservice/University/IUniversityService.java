package fr.gopartner.personservice.University;

import java.util.List;
import java.util.Optional;

public interface IUniversityService {

    List<University> retrieveAlluniversities();

    University addUniversity(University s);

    University updateUniversity(University u);

    Optional<University> retrieveUniversity(int id);

    void deleteUniversity(int id);
}
