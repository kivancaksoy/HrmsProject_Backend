package kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices;

import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateCoverLetterRequest;
import kodlamaio.hrmsProject.core.utilities.results.Result;

public interface CoverLetterService {
    Result add(CreateCoverLetterRequest createCoverLetterRequest);
}
