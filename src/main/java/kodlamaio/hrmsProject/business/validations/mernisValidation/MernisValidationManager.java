package kodlamaio.hrmsProject.business.validations.mernisValidation;

import kodlamaio.hrmsProject.business.requests.CreateJobSeekerRequest;
import org.springframework.stereotype.Service;

@Service
public class MernisValidationManager implements MernisValidationService {
    @Override
    public boolean checkIfRealPerson(CreateJobSeekerRequest createJobSeekerRequest) {
        return true;
    }
}
