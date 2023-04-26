package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.business.requests.CreateEmployer;
import kodlamaio.hrmsProject.business.responses.GetAllEmployers;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;

import java.util.List;

public interface EmployerService {
    Result add(CreateEmployer createEmployer);
    DataResult<List<GetAllEmployers>> getAll();
}
