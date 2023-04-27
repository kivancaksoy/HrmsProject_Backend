package kodlamaio.hrmsProject.api.controllers;

import jakarta.validation.Valid;
import kodlamaio.hrmsProject.business.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.business.requests.CreateJobSeekerRequest;
import kodlamaio.hrmsProject.business.responses.GetAllJobSeekersResponse;
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
    public DataResult<List<GetAllJobSeekersResponse>> getAll(){
        return jobSeekerService.getAll();
    }

    @PostMapping("/register")
    public Result add(@RequestBody @Valid CreateJobSeekerRequest createJobSeekerRequest){
        return jobSeekerService.add(createJobSeekerRequest);
    }

}
