package kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import org.springframework.web.multipart.MultipartFile;

public interface JobSeekerImageService {
    Result uploadFile(MultipartFile file, int jobSeekerId);
}
