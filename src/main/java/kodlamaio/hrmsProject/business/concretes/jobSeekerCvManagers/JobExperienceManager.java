package kodlamaio.hrmsProject.business.concretes.jobSeekerCvManagers;

import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.JobExperienceService;
import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateJobExperienceRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllJobExperiencesResponse;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.jobSeekerCvInformationDaos.JobExperienceDao;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.JobExperience;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {
    private final JobExperienceDao jobExperienceDao;
    private final ModelMapperService modelMapperService;

    public JobExperienceManager(JobExperienceDao jobExperienceDao, ModelMapperService modelMapperService) {
        this.jobExperienceDao = jobExperienceDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(List<CreateJobExperienceRequest> createJobExperienceRequests) {
        List<JobExperience> jobExperiences =
                createJobExperienceRequests.stream().map(createJobExperienceRequest ->
                        modelMapperService.forRequest()
                                .map(createJobExperienceRequest, JobExperience.class)).toList();
        jobExperienceDao.saveAll(jobExperiences);
        return new SuccessResult("Job experiences added.");
    }

    @Override
    public DataResult<List<GetAllJobExperiencesResponse>> getAllByJobSeekerIdOrderByGraduatedYearDesc(int jobSeekerId) {
        List<JobExperience> jobExperiences = jobExperienceDao.findAllByJobSeekerIdOrderByEndYearDesc(jobSeekerId);

        List<GetAllJobExperiencesResponse> getAllJobExperiencesResponses =
                jobExperiences.stream().map(jobExperience ->
                        modelMapperService.forResponse().map(jobExperience, GetAllJobExperiencesResponse.class)).toList();
        return new SuccessDataResult<>(getAllJobExperiencesResponses, "Job experiences listed.");
    }
}
