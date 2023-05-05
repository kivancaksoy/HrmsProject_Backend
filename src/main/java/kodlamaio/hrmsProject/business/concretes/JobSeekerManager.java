package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.business.businessRules.JobSeekerBusinessRules;
import kodlamaio.hrmsProject.business.requests.CreateJobSeekerRequest;
import kodlamaio.hrmsProject.business.responses.GetAllJobSeekersResponse;
import kodlamaio.hrmsProject.core.utilities.businessRules.BusinessRules;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.UserDao;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
import kodlamaio.hrmsProject.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private ModelMapperService modelMapperService;
    private JobSeekerBusinessRules jobSeekerBusinessRules;

    @Override
    public Result add(CreateJobSeekerRequest createJobSeekerRequest) {
        var businessResult = BusinessRules.Run(jobSeekerBusinessRules.emailCanNotBeDublicated(createJobSeekerRequest.getEmail()),
                jobSeekerBusinessRules.tcknCanNotBeDublicated(createJobSeekerRequest.getTckn()),
                jobSeekerBusinessRules.isEmailVerified(createJobSeekerRequest.getEmail()),
                jobSeekerBusinessRules.isPersonVerified(createJobSeekerRequest));

        if (businessResult != null)
            return businessResult;

        JobSeeker jobseeker = modelMapperService.forRequest().map(createJobSeekerRequest, JobSeeker.class);
        jobSeekerDao.save(jobseeker);

        return new SuccessResult("Job seeker created.");
    }

    @Override
    public DataResult<List<GetAllJobSeekersResponse>> getAll() {
        List<JobSeeker> jobSeekers = jobSeekerDao.findAll();

        List<GetAllJobSeekersResponse> getAllJobSeekerResponses =
                jobSeekers.stream().map(jobSeeker ->
                        modelMapperService.forResponse()
                                .map(jobSeeker, GetAllJobSeekersResponse.class)).toList();
        return new SuccessDataResult<>(getAllJobSeekerResponses, "Job seekers listed.");
    }
}
