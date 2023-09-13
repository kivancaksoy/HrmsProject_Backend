package kodlamaio.hrmsProject.business.concretes.jobSeekerCvManagers;

import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.JobSeekerImageService;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllJobSeekerImagesResponse;
import kodlamaio.hrmsProject.business.services.storage.FileOperations;
import kodlamaio.hrmsProject.business.services.storage.FileService;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.jobSeekerCvInformationDaos.JobSeekerImageDao;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.JobSeekerImage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class JobSeekerImageManager implements JobSeekerImageService {
    private final JobSeekerImageDao jobSeekerImageDao;
    private final JobSeekerDao jobSeekerDao; //Todo Bunun yerine JobSeekerService'i kullanmak faced yaklaşımına uygun olur.
    private final FileService fileService;
    private final ModelMapperService modelMapperService;

    public JobSeekerImageManager(JobSeekerImageDao jobSeekerImageDao, JobSeekerDao jobSeekerDao, FileService fileService, ModelMapperService modelMapperService) {
        this.jobSeekerImageDao = jobSeekerImageDao;
        this.jobSeekerDao = jobSeekerDao;
        this.fileService = fileService;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result uploadFile(MultipartFile file, int jobSeekerId) {
        JobSeekerImage jobSeekerImage = new JobSeekerImage();

        try {
            String filePath = fileService.uploadFile(file);

            jobSeekerImage.setJobSeeker(jobSeekerDao.findById(jobSeekerId).orElseThrow());
            jobSeekerImage.setImageName(FileOperations.getFileName(file));
            jobSeekerImage.setStorageName(fileService.getFileStorageName());
            jobSeekerImage.setImagePath(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        jobSeekerImageDao.save(jobSeekerImage);

        return new SuccessResult("File uploaded.");
    }

    @Override
    public DataResult<List<GetAllJobSeekerImagesResponse>> getAllJobSeekerImagesByJobSeekerId(int jobSeekerId) {
        List<JobSeekerImage> jobSeekerImages = jobSeekerImageDao.findAllByJobSeekerId(jobSeekerId);

        List<GetAllJobSeekerImagesResponse> getAllJobSeekerImagesResponses =
                jobSeekerImages.stream().map(jobSeekerImage ->
                        modelMapperService.forResponse().map(jobSeekerImage, GetAllJobSeekerImagesResponse.class)).toList();
        return new SuccessDataResult<>(getAllJobSeekerImagesResponses);
    }
}
