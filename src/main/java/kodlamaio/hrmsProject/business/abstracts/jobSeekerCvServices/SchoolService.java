package kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices;

import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateSchoolRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllSchoolsResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;

import java.util.List;

public interface SchoolService {
    Result add(List<CreateSchoolRequest> createSchoolRequests);
    DataResult<List<GetAllSchoolsResponse>> getAllOrderByGraduatedYearDesc();
}
