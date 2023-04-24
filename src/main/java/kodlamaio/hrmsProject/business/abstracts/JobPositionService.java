package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.business.responses.GetAllJobPositionsResponse;

import java.util.List;

public interface JobPositionService {

    List<GetAllJobPositionsResponse> getAll();
}
