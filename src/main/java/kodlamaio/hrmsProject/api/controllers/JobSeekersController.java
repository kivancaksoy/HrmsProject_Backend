package kodlamaio.hrmsProject.api.controllers;

import jakarta.validation.Valid;
import kodlamaio.hrmsProject.business.abstracts.EmployerService;
import kodlamaio.hrmsProject.business.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.business.requests.CreateEmployer;
import kodlamaio.hrmsProject.business.requests.CreateJobSeeker;
import kodlamaio.hrmsProject.business.responses.GetAllJobSeekers;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
@AllArgsConstructor
public class JobSeekersController {

    private JobSeekerService jobSeekerService;

    @GetMapping("/getall")
    public DataResult<List<GetAllJobSeekers>> getAll(){
        return jobSeekerService.getAll();
    }

    @PostMapping("/register")
    public Result add(@RequestBody @Valid CreateJobSeeker createJobSeeker){
        return jobSeekerService.add(createJobSeeker);
    }

}
