package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.EmploymentTypeService;
import kodlamaio.hrmsProject.business.responses.GetAllEmploymentTypesResponse;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.EmploymentTypeDao;
import kodlamaio.hrmsProject.entities.concretes.EmploymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploymentTypeManager implements EmploymentTypeService {
    private final EmploymentTypeDao employmentTypeDao;
    private final ModelMapperService modelMapperService;

    @Autowired
    public EmploymentTypeManager(EmploymentTypeDao employmentTypeDao, ModelMapperService modelMapperService) {
        this.employmentTypeDao = employmentTypeDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<GetAllEmploymentTypesResponse>> getAll() {
        List<EmploymentType> employmentTypes = employmentTypeDao.findAll();

        List<GetAllEmploymentTypesResponse> getAllEmploymentTypesResponses =
                employmentTypes.stream().map(employmentType ->
                        modelMapperService.forResponse().map(employmentType, GetAllEmploymentTypesResponse.class)).toList();
        return new SuccessDataResult<>(getAllEmploymentTypesResponses, "Employment types lsited.");
    }
}
