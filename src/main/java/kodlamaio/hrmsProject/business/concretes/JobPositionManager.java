package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.JobPositionService;
import kodlamaio.hrmsProject.business.services.businessRules.JobPositionBusinessRules;
import kodlamaio.hrmsProject.business.requests.CreateJobPositionRequest;
import kodlamaio.hrmsProject.business.responses.GetAllJobPositionsResponse;
import kodlamaio.hrmsProject.core.utilities.businessRules.BusinessRules;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.*;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrmsProject.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private final JobPositionDao jobPositionDao;
    private final ModelMapperService modelMapperService;
    private final JobPositionBusinessRules jobPositionBusinessRules;

    public JobPositionManager(JobPositionDao jobPositionDao, ModelMapperService modelMapperService, JobPositionBusinessRules jobPositionBusinessRules) {
        this.jobPositionDao = jobPositionDao;
        this.modelMapperService = modelMapperService;
        this.jobPositionBusinessRules = jobPositionBusinessRules;
    }

    @Override
    public DataResult<List<GetAllJobPositionsResponse>> getAll() {
        List<JobPosition> jobPositions = jobPositionDao.findAll();

        List<GetAllJobPositionsResponse> getAllJobPositionsResponses =
                jobPositions.stream().map(jobPosition ->
                                modelMapperService.forResponse()
                                        .map(jobPosition, GetAllJobPositionsResponse.class))
                        .toList();
        return new SuccessDataResult<List<GetAllJobPositionsResponse>>(getAllJobPositionsResponses, "Job positions listed.");
    }

    public Result add(CreateJobPositionRequest createJobPositionRequest) {
        var businessResult = BusinessRules.Run(jobPositionBusinessRules.doesJobPositionNameExist(createJobPositionRequest.getJobPositionName()));

        if (businessResult != null)
            return businessResult;

        JobPosition jobPosition =
                modelMapperService.forRequest().map(createJobPositionRequest, JobPosition.class);
        jobPositionDao.save(jobPosition);
        return new SuccessResult("Job position added.");
    }
}
