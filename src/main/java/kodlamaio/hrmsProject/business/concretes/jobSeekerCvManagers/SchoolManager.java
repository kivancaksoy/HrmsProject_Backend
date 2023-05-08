package kodlamaio.hrmsProject.business.concretes.jobSeekerCvManagers;

import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.SchoolService;
import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateSchoolRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllSchoolsResponse;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.jobSeekerCvInformationDaos.SchoolDao;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    private final SchoolDao schoolDao;
    private final ModelMapperService modelMapperService;

    @Autowired
    public SchoolManager(SchoolDao schoolDao, ModelMapperService modelMapperService) {
        this.schoolDao = schoolDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(List<CreateSchoolRequest> createSchoolRequests) {
        List<School> schools =
                createSchoolRequests.stream().map(createSchoolRequest ->
                        modelMapperService.forRequest()
                                .map(createSchoolRequest, School.class)).toList();
        schoolDao.saveAll(schools);
        return new SuccessResult("Schools added.");
    }

    @Override
    public DataResult<List<GetAllSchoolsResponse>> getAllOrderByGraduatedYearDesc() {
        List<School> schools = schoolDao.findAllByOrderByGraduatedYearDesc();



        List<GetAllSchoolsResponse> getAllSchoolsResponses =
                schools.stream().map(school ->
                        modelMapperService.forResponse()
                                .map(school, GetAllSchoolsResponse.class)).toList();
        return new SuccessDataResult<>(getAllSchoolsResponses, "Schools listed.");
    }
}
