package kodlamaio.hrmsProject.business.validations.mernisValidation;

import kodlamaio.hrmsProject.business.requests.CreateJobSeekerRequest;

public interface MernisValidationService {
    boolean checkIfRealPerson(CreateJobSeekerRequest createJobSeekerRequest);
}
