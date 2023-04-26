package kodlamaio.hrmsProject.business.validations.mernisValidation;

import kodlamaio.hrmsProject.business.requests.CreateJobSeeker;
import org.springframework.stereotype.Service;

@Service
public class MernisValidationManager implements MernisValidationService {
    @Override
    public boolean checkIfRealPerson(CreateJobSeeker createJobSeeker) {
        return true;
    }
}
