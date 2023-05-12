package kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices;

import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllCvInformationResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;

public interface CvInformationService {
    DataResult<GetAllCvInformationResponse> getAllCvInformationByJobSeekerId(int jobSeekerId);
}
