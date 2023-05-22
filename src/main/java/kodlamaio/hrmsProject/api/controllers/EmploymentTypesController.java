package kodlamaio.hrmsProject.api.controllers;

import kodlamaio.hrmsProject.business.abstracts.EmploymentTypeService;
import kodlamaio.hrmsProject.business.responses.GetAllEmploymentTypesResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employmentTypes")
public class EmploymentTypesController {
    private final EmploymentTypeService employmentTypeService;

    public EmploymentTypesController(EmploymentTypeService employmentTypeService) {
        this.employmentTypeService = employmentTypeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllEmploymentTypesResponse>> getAll(){
        return employmentTypeService.getAll();
    }
}
