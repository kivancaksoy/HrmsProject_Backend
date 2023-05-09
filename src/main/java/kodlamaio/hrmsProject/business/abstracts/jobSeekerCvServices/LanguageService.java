package kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices;

import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateLanguageRequest;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LanguageService {
    Result add(List<CreateLanguageRequest> createLanguageRequests);
}
