package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.business.requests.CreateJobSeekerRequest;
import kodlamaio.hrmsProject.business.responses.GetAllJobSeekersResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;

import java.util.List;

public interface JobSeekerService {
    Result add(CreateJobSeekerRequest createJobSeekerRequest);
    DataResult<List<GetAllJobSeekersResponse>> getAll();
}
