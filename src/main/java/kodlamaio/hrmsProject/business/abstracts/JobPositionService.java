package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.business.responses.GetAllJobPositionsResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;

import java.util.List;

public interface JobPositionService {

    DataResult<List<GetAllJobPositionsResponse>> getAll();
}
