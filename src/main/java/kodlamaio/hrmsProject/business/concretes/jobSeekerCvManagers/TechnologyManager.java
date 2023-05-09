package kodlamaio.hrmsProject.business.concretes.jobSeekerCvManagers;

import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.TechnologyService;
import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateTechnologyRequest;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.jobSeekerCvInformationDaos.TechnologyDao;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnologyManager implements TechnologyService {
    private final TechnologyDao technologyDao;
    private final ModelMapperService modelMapperService;

    @Autowired
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
}
