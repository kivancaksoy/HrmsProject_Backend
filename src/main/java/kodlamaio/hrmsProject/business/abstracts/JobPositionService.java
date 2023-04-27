package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.business.requests.CreateJobPositionRequest;
import kodlamaio.hrmsProject.business.responses.GetAllJobPositionsResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;

import java.util.List;

public interface JobPositionService {

    DataResult<List<GetAllJobPositionsResponse>> getAll();
    Result add(CreateJobPositionRequest createJobPositionRequest);
}
