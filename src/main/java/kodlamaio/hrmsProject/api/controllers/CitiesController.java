package kodlamaio.hrmsProject.api.controllers;

import kodlamaio.hrmsProject.business.abstracts.CityService;
import kodlamaio.hrmsProject.business.responses.GetAllCitiesResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

    private final CityService cityService;

    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllCitiesResponse>> getAll() {
        return cityService.getAll();
    }
}
