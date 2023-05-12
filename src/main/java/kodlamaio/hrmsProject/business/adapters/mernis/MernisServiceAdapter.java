package kodlamaio.hrmsProject.business.adapters.mernis;

import kodlamaio.hrmsProject.business.requests.CreateJobSeekerRequest;
import kodlamaio.hrmsProject.business.services.validations.personValidations.PersonValidationService;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements PersonValidationService {
    @Override
    public boolean checkIfRealPerson(CreateJobSeekerRequest createJobSeekerRequest) {
        return true;
    }
}
