package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.business.services.businessRules.JobSeekerBusinessRules;
import kodlamaio.hrmsProject.business.requests.CreateJobSeekerRequest;
import kodlamaio.hrmsProject.business.responses.GetAllJobSeekersResponse;
import kodlamaio.hrmsProject.business.services.validations.emailVerifications.EmailVerificationService;
import kodlamaio.hrmsProject.core.utilities.businessRules.BusinessRules;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private final JobSeekerDao jobSeekerDao;
    private final ModelMapperService modelMapperService;
    private final JobSeekerBusinessRules jobSeekerBusinessRules;
    private final EmailVerificationService emailVerificationService;

    public JobSeekerManager(JobSeekerDao jobSeekerDao, ModelMapperService modelMapperService, JobSeekerBusinessRules jobSeekerBusinessRules, EmailVerificationService emailVerificationService) {
        this.jobSeekerDao = jobSeekerDao;
        this.modelMapperService = modelMapperService;
        this.jobSeekerBusinessRules = jobSeekerBusinessRules;
        this.emailVerificationService = emailVerificationService;
    }

    @Override
    public Result add(CreateJobSeekerRequest createJobSeekerRequest) {
        var businessResult = BusinessRules.Run(jobSeekerBusinessRules.emailCanNotBeDuplicated(createJobSeekerRequest.getEmail()),
                jobSeekerBusinessRules.CanCanCanNotBeDuplicated(createJobSeekerRequest.getTckn()),
                jobSeekerBusinessRules.isPersonVerified(createJobSeekerRequest));

        if (businessResult != null)
            return businessResult;

        JobSeeker jobseeker = modelMapperService.forRequest().map(createJobSeekerRequest, JobSeeker.class);
        JobSeeker createdJobSeeker = jobSeekerDao.save(jobseeker);

        emailVerificationService.createEmailVerificationCodeJobSeeker(createdJobSeeker);
        return new SuccessResult("An email has been sent, please check your email.");
    }

    @Override
    public DataResult<List<GetAllJobSeekersResponse>> getAll() {
        //List<JobSeeker> jobSeekers = jobSeekerDao.findAll();
        List<JobSeeker> jobSeekers = jobSeekerDao.getAllActiveJobSeekers();

        List<GetAllJobSeekersResponse> getAllJobSeekerResponses =
                jobSeekers.stream().map(jobSeeker ->
                        modelMapperService.forResponse()
                                .map(jobSeeker, GetAllJobSeekersResponse.class)).toList();
        return new SuccessDataResult<>(getAllJobSeekerResponses, "Job seekers listed.");
    }
}
