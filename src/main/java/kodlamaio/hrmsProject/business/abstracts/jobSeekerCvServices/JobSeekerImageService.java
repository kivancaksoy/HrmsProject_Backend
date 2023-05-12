package kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices;

import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllJobSeekerImagesResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobSeekerImageService {
    Result uploadFile(MultipartFile file, int jobSeekerId);
    DataResult<List<GetAllJobSeekerImagesResponse>> getAllJobSeekerImagesByJobSeekerId(int jobSeekerId);
}
