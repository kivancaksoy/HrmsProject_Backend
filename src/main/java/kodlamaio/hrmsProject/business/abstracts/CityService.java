package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.business.responses.GetAllCitiesResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;

import java.util.List;

public interface CityService {
    DataResult<List<GetAllCitiesResponse>> getAll();
}
