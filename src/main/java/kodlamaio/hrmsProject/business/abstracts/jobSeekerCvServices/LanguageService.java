package kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices;

import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateLanguageRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllLanguagesResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LanguageService {
    Result add(List<CreateLanguageRequest> createLanguageRequests);
    DataResult<List<GetAllLanguagesResponse>> getAllLanguagesByJobSeekerId(int jobSeekerId);
}
