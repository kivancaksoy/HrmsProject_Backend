package kodlamaio.hrmsProject.api.controllers;

import jakarta.validation.Valid;
import kodlamaio.hrmsProject.business.abstracts.JobAdvertisementService;
import kodlamaio.hrmsProject.business.requests.CreateJobAdvertisementRequest;
import kodlamaio.hrmsProject.business.responses.GetAllJobAdvertisementsResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisements")
@AllArgsConstructor
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @GetMapping("/getall")
    public DataResult<List<GetAllJobAdvertisementsResponse>> getAll(){
        return jobAdvertisementService.getAll();
    }

    @GetMapping("/getallisactive")
    public DataResult<List<GetAllJobAdvertisementsResponse>> getAllIsActive(){
        return jobAdvertisementService.getAllIsActive();
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateJobAdvertisementRequest createJobAdvertisementRequest) {
        return jobAdvertisementService.add(createJobAdvertisementRequest);
    }
}
