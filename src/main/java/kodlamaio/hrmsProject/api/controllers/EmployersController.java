package kodlamaio.hrmsProject.api.controllers;

import jakarta.validation.Valid;
import kodlamaio.hrmsProject.business.abstracts.EmployerService;
import kodlamaio.hrmsProject.business.requests.CreateEmployerRequest;
import kodlamaio.hrmsProject.business.responses.GetAllEmployersResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
@AllArgsConstructor
public class EmployersController {

    private EmployerService employerService;

    @GetMapping("/getall")
    public DataResult<List<GetAllEmployersResponse>> getAll(){
        return employerService.getAll();
    }

    @PostMapping("/register")
    public Result add(@RequestBody @Valid CreateEmployerRequest createEmployerRequest){
        return employerService.add(createEmployerRequest);
    }
}
