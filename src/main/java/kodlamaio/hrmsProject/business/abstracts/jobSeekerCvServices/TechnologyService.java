package kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices;

import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateTechnologyRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllTechnologiesResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;

import java.util.List;

public interface TechnologyService {
    Result add(CreateTechnologyRequest createTechnologyRequest);
    DataResult<List<GetAllTechnologiesResponse>> getAllTechnologiesByJobSeekerId(int jobSeekerId);
}
