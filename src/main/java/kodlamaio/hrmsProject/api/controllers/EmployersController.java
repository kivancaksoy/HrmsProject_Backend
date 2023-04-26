package kodlamaio.hrmsProject.api.controllers;

import jakarta.validation.Valid;
import kodlamaio.hrmsProject.business.abstracts.EmployerService;
import kodlamaio.hrmsProject.business.requests.CreateEmployer;
import kodlamaio.hrmsProject.business.responses.GetAllEmployers;
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
    public DataResult<List<GetAllEmployers>> getAll(){
        return employerService.getAll();
    }

    @PostMapping("/register")
    public Result add(@RequestBody @Valid CreateEmployer createEmployer){
        return employerService.add(createEmployer);
    }
}
