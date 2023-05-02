package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.business.requests.CreateCompanyRequest;
import kodlamaio.hrmsProject.business.responses.GetAllCompaniesResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;

import java.util.List;

public interface CompanyService {
    Result add(CreateCompanyRequest createCompanyRequest);
    DataResult<List<GetAllCompaniesResponse>> getAll();
}
