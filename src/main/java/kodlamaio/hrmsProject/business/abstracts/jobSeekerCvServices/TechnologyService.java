package kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices;

import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateTechnologyRequest;
import kodlamaio.hrmsProject.core.utilities.results.Result;

public interface TechnologyService {
    Result add(CreateTechnologyRequest createTechnologyRequest);
}
