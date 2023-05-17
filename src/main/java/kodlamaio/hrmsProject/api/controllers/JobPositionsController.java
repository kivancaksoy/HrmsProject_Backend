package kodlamaio.hrmsProject.api.controllers;

import jakarta.validation.Valid;
import kodlamaio.hrmsProject.business.abstracts.JobPositionService;
import kodlamaio.hrmsProject.business.requests.CreateJobPositionRequest;
import kodlamaio.hrmsProject.business.responses.GetAllJobPositionsResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPositions")
@AllArgsConstructor
@CrossOrigin
public class JobPositionsController {
    private JobPositionService jobPositionService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllJobPositionsResponse>> getAll(){
        DataResult<List<GetAllJobPositionsResponse>> result = jobPositionService.getAll();
        return result;
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateJobPositionRequest createJobPositionRequest){
        Result result = jobPositionService.add(createJobPositionRequest);
        return result;
    }
}
