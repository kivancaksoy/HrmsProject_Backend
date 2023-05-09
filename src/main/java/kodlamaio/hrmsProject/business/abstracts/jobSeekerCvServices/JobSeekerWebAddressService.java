package kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices;

import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateJobSeekerWebAddressRequest;
import kodlamaio.hrmsProject.core.utilities.results.Result;

public interface JobSeekerWebAddressService {
    Result add(CreateJobSeekerWebAddressRequest createJobSeekerWebAddressRequest);
}
