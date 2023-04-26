package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.JobPositionService;
import kodlamaio.hrmsProject.business.responses.GetAllJobPositionsResponse;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
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


    @Override
    public DataResult<List<GetAllJobPositionsResponse>> getAll() {
        List<JobPosition> jobPositions = jobPositionDao.findAll();

        List<GetAllJobPositionsResponse> getAllJobPositionsResponses =
                jobPositions.stream().map(jobPosition ->
                                modelMapperService.forResponse()
                                        .map(jobPosition, GetAllJobPositionsResponse.class))
                        .toList();
        return new SuccessDataResult<List<GetAllJobPositionsResponse>>(getAllJobPositionsResponses, "Tüm iş pozisyonları listelendi.");
    }
}
