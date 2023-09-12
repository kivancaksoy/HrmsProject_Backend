package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.CityService;
import kodlamaio.hrmsProject.business.responses.GetAllCitiesResponse;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CityDao;
import kodlamaio.hrmsProject.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
    private final CityDao cityDao;
    private final ModelMapperService modelMapperService;

    public CityManager(CityDao cityDao, ModelMapperService modelMapperService) {
        this.cityDao = cityDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<GetAllCitiesResponse>> getAll() {
        List<City> cities = cityDao.findAll();

        List<GetAllCitiesResponse> getAllCitiesResponses =
                cities.stream().map(city ->
                        modelMapperService.forResponse().map(city, GetAllCitiesResponse.class)).toList();
        return new SuccessDataResult<>(getAllCitiesResponses, "Cities listed.");
    }
}
