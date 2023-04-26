package kodlamaio.hrmsProject.business.validations.mernisValidation;

import kodlamaio.hrmsProject.business.requests.CreateJobSeeker;

public interface MernisValidationService {
    boolean checkIfRealPerson(CreateJobSeeker createJobSeeker);
}
