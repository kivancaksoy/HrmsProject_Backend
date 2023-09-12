package kodlamaio.hrmsProject.business.concretes.jobSeekerCvManagers;

import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.TechnologyService;
import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateTechnologyRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllTechnologiesResponse;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.jobSeekerCvInformationDaos.TechnologyDao;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {
    private final TechnologyDao technologyDao;
    private final ModelMapperService modelMapperService;

    public TechnologyManager(TechnologyDao technologyDao, ModelMapperService modelMapperService) {
        this.technologyDao = technologyDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateTechnologyRequest createTechnologyRequest) {
        Technology technology = modelMapperService.forRequest().map(createTechnologyRequest, Technology.class);
        technologyDao.save(technology);
        return new SuccessResult("Technology added.");
    }

    @Override
    public DataResult<List<GetAllTechnologiesResponse>> getAllTechnologiesByJobSeekerId(int jobSeekerId) {
        List<Technology> technologies = technologyDao.findAllByJobSeekerId(jobSeekerId);

        List<GetAllTechnologiesResponse> getAllTechnologiesResponses =
                technologies.stream().map(technology ->
                        modelMapperService.forResponse().map(technology, GetAllTechnologiesResponse.class)).toList();
        return new SuccessDataResult<>(getAllTechnologiesResponses);
    }
}
