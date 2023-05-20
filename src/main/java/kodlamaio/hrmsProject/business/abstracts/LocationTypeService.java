package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.business.responses.GetAllLocationTypesResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;

import java.util.List;

public interface LocationTypeService {
    DataResult<List<GetAllLocationTypesResponse>> getAll();
}
