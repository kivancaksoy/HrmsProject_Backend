package kodlamaio.hrmsProject.business.services.validations.personValidations;

import kodlamaio.hrmsProject.business.requests.CreateJobSeekerRequest;

public interface PersonValidationService {
    boolean checkIfRealPerson(CreateJobSeekerRequest createJobSeekerRequest);
}
