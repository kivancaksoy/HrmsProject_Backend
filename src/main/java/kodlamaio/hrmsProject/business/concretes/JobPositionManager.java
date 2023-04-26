package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.JobPositionService;
import kodlamaio.hrmsProject.business.requests.CreateJobPosition;
import kodlamaio.hrmsProject.business.responses.GetAllJobPositionsResponse;
import kodlamaio.hrmsProject.business.rules.JobPositonRules;
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
    private JobPositonRules jobPositonRules;


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

        if (jobPositonRules.doesJobPositionNameExist(createJobPosition.getPositionName())) {
            return new ErrorResult("Job position name already exists.");
        }

        JobPosition jobPosition =
                modelMapperService.forRequest().map(createJobPosition, JobPosition.class);
        jobPositionDao.save(jobPosition);
        return new SuccessResult("Job position added.");
    }
}
