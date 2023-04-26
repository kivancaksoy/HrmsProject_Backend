package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.JobPositionService;
import kodlamaio.hrmsProject.business.businessRules.JobPositonBusinessRules;
import kodlamaio.hrmsProject.business.requests.CreateJobPosition;
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
@AllArgsConstructor
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;
    private ModelMapperService modelMapperService;
    private JobPositonBusinessRules jobPositonBusinessRules;


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

    public Result add(CreateJobPosition createJobPosition) {
        var businessResult = BusinessRules.Run(jobPositonBusinessRules.doesJobPositionNameExist(createJobPosition.getJobPositionName()));

        if (businessResult != null)
            return businessResult;

        JobPosition jobPosition =
                modelMapperService.forRequest().map(createJobPosition, JobPosition.class);
        jobPositionDao.save(jobPosition);
        return new SuccessResult("Job position added.");
    }
}
