package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.LocationTypeService;
import kodlamaio.hrmsProject.business.responses.GetAllLocationTypesResponse;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.LocationTypeDao;
import kodlamaio.hrmsProject.entities.concretes.LocationType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationTypeManager implements LocationTypeService {
    private final LocationTypeDao locationTypeDao;
    private final ModelMapperService modelMapperService;

    public LocationTypeManager(LocationTypeDao locationTypeDao, ModelMapperService modelMapperService) {
        this.locationTypeDao = locationTypeDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<GetAllLocationTypesResponse>> getAll() {
        List<LocationType> locationTypes = locationTypeDao.findAll();

        List<GetAllLocationTypesResponse> getAllLocationTypesResponses =
                locationTypes.stream().map(locationType ->
                        modelMapperService.forResponse().map(locationType, GetAllLocationTypesResponse.class)).toList();
        return new SuccessDataResult<>(getAllLocationTypesResponses, "Location types listed.");
    }
}
