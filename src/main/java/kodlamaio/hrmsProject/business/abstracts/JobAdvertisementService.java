package kodlamaio.hrmsProject.business.abstracts;

import kodlamaio.hrmsProject.business.requests.CreateJobAdvertisementRequest;
import kodlamaio.hrmsProject.business.responses.GetAllJobAdvertisementsResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;

import java.util.List;

public interface JobAdvertisementService {
    Result add(CreateJobAdvertisementRequest createJobAdvertisementRequest);
    DataResult<List<GetAllJobAdvertisementsResponse>> getAll();
    DataResult<List<GetAllJobAdvertisementsResponse>> getAllActiveJobAdvertisements();
    DataResult<List<GetAllJobAdvertisementsResponse>> getAllActiveJobAdvertisementsSortedByJobPostingDate();
    DataResult<List<GetAllJobAdvertisementsResponse>> getAllActiveJobAdvertisementsAndCompanyNameIs(String companyName);
    Result setJobAdvertisementStatusFalse (int jobAdvertisementId);
}
