package fr.gopartner.personservice.University;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService implements IUniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public List<University> retrieveAlluniversities() {
        return universityRepository.findAll();
    }

    @Override
    public University addUniversity(University s) {
        return universityRepository.save(s);
    }

    @Override
    public University updateUniversity(University u) {
        return universityRepository.save(u);
    }

    @Override
    public Optional<University> retrieveUniversity(int id) {
        return universityRepository.findById(id);
    }

    @Override
    public void deleteUniversity(int id) {
        universityRepository.deleteById(id);
    }
}
