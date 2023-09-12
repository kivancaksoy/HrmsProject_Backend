package kodlamaio.hrmsProject.api.controllers;

import jakarta.validation.Valid;
import kodlamaio.hrmsProject.business.abstracts.CompanyService;
import kodlamaio.hrmsProject.business.requests.CreateCompanyRequest;
import kodlamaio.hrmsProject.business.responses.GetAllCompaniesResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin
public class CompaniesController {

    private final CompanyService companyService;

    public CompaniesController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllCompaniesResponse>> getAll(){
        return companyService.getAll();
    }

    @PostMapping("/register")
    public Result add(@RequestBody @Valid CreateCompanyRequest createCompanyRequest){
        return companyService.add(createCompanyRequest);
    }
}
