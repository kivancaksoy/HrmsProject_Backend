package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.business.requests.CreateEmployerRequest;
import kodlamaio.hrmsProject.business.responses.GetAllEmployersResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;

import java.util.List;

public interface EmployerService {
    Result add(CreateEmployerRequest createEmployerRequest);
    DataResult<List<GetAllEmployersResponse>> getAll();
}
