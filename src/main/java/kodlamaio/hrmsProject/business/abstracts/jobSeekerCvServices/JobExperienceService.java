package kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices;

import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateJobExperienceRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllJobExperiencesResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;

import java.util.List;

public interface JobExperienceService {
    Result add(List<CreateJobExperienceRequest> createJobExperienceRequests);
    DataResult<List<GetAllJobExperiencesResponse>> getAllByJobSeekerIdOrderByGraduatedYearDesc(int jobSeekerId);
}
