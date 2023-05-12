package kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices;

import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateCoverLetterRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetCoverLetterResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.CoverLetter;

public interface CoverLetterService {
    Result add(CreateCoverLetterRequest createCoverLetterRequest);
    DataResult<GetCoverLetterResponse> getCoverLetterByJobSeekerId(int jobSeekerId);
}
