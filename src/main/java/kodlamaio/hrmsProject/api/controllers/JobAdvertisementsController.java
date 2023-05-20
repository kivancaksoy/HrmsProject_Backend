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
@RequestMapping("/api/jobAdvertisements")
@AllArgsConstructor
@CrossOrigin
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllJobAdvertisementsResponse>> getAll(){
        return jobAdvertisementService.getAll();
    }

    @GetMapping("/getAllActive")
    public DataResult<List<GetAllJobAdvertisementsResponse>> getAllActive(){
        return jobAdvertisementService.getAllActiveJobAdvertisements();
    }

    @GetMapping("/getAllActiveJobAdvertisementsSortedByJobPostingDate")
    public DataResult<List<GetAllJobAdvertisementsResponse>> getAllActiveSortedByJobPostingDate(){
        return jobAdvertisementService.getAllActiveJobAdvertisementsSortedByJobPostingDate();
    }

    @GetMapping("/getAllActiveJobAdvertisementsAndCompanyNameIs")
    public DataResult<List<GetAllJobAdvertisementsResponse>> getAllActiveAndCompanyNameIs(String companyName){
        return jobAdvertisementService.getAllActiveJobAdvertisementsAndCompanyNameIs(companyName);
    }

    @GetMapping("/getAllActiveAndConfirmedJobAdvertisements")
    public DataResult<List<GetAllJobAdvertisementsResponse>> getAllActiveAndConfirmedJobAdvertisements(){
        return jobAdvertisementService.getAllActiveAndConfirmedJobAdvertisements();
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateJobAdvertisementRequest createJobAdvertisementRequest) {
        return jobAdvertisementService.add(createJobAdvertisementRequest);
    }

    @PutMapping("/setJobAdvertisementStatusFalse/{jobAdvertisementId}")
    public Result setJobAdvertisementStatusFalse(@PathVariable int jobAdvertisementId){
        return jobAdvertisementService.setJobAdvertisementStatusFalse(jobAdvertisementId);
    }
}
