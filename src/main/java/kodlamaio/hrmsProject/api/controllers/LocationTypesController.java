package kodlamaio.hrmsProject.api.controllers;

import kodlamaio.hrmsProject.business.abstracts.LocationTypeService;
import kodlamaio.hrmsProject.business.responses.GetAllLocationTypesResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/locationTypes")
@CrossOrigin
public class LocationTypesController {
    private final LocationTypeService locationTypeService;

    public LocationTypesController(LocationTypeService locationTypeService) {
        this.locationTypeService = locationTypeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllLocationTypesResponse>> getAll(){
        return locationTypeService.getAll();
    }
}
