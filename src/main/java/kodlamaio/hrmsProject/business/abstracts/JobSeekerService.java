package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.business.requests.CreateJobSeeker;
import kodlamaio.hrmsProject.business.responses.GetAllJobSeekers;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;

import java.util.List;

public interface JobSeekerService {
    Result add(CreateJobSeeker createJobSeeker);
    DataResult<List<GetAllJobSeekers>> getAll();
}
