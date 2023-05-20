package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.business.responses.GetAllEmploymentTypesResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;

import java.util.List;

public interface EmploymentTypeService {
    DataResult<List<GetAllEmploymentTypesResponse>> getAll();
}
