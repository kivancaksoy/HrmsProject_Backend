package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.business.businessRules.JobSeekerBusinessRules;
import kodlamaio.hrmsProject.business.requests.CreateJobSeeker;
import kodlamaio.hrmsProject.business.responses.GetAllJobSeekers;
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
    private UserDao userDao;
    private ModelMapperService modelMapperService;
    private JobSeekerBusinessRules jobSeekerBusinessRules;

    @Override
    public Result add(CreateJobSeeker createJobSeeker) {
        var businessResult = BusinessRules.Run(jobSeekerBusinessRules.emailCanNotBeDublicated(createJobSeeker.getEmail()),
                jobSeekerBusinessRules.tcknCanNotBeDublicated(createJobSeeker.getTckn()),
                jobSeekerBusinessRules.isEmailVerified(createJobSeeker.getEmail()),
                jobSeekerBusinessRules.isPersonVerified(createJobSeeker));

        if (businessResult != null)
            return businessResult;

        User user = modelMapperService.forRequest().map(createJobSeeker, User.class);
        JobSeeker jobseeker = modelMapperService.forRequest().map(createJobSeeker, JobSeeker.class);

        User createdUser = userDao.save(user);
        jobseeker.setJobSeekerId(createdUser.getId());
        jobSeekerDao.save(jobseeker);

        return new SuccessResult("Job seeker created.");
    }

    @Override
    public DataResult<List<GetAllJobSeekers>> getAll() {
        List<JobSeeker> jobSeekers = jobSeekerDao.findAll();

        List<GetAllJobSeekers> getAllJobSeekers =
                jobSeekers.stream().map(jobSeeker ->
                        modelMapperService.forResponse()
                                .map(jobSeeker, GetAllJobSeekers.class)).toList();
        return new SuccessDataResult<>(getAllJobSeekers, "Job seekers listed.");
    }
}
