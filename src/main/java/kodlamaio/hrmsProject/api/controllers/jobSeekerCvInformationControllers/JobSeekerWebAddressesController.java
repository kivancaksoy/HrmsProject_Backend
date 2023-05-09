package kodlamaio.hrmsProject.api.controllers.jobSeekerCvInformationControllers;

import jakarta.validation.Valid;
import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.JobSeekerWebAddressService;
import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateJobSeekerWebAddressRequest;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobSeekerWebAddresses")
public class JobSeekerWebAddressesController {
    private final JobSeekerWebAddressService jobSeekerWebAddressService;

    @Autowired
    public JobSeekerWebAddressesController(JobSeekerWebAddressService jobSeekerWebAddressService) {
        this.jobSeekerWebAddressService = jobSeekerWebAddressService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateJobSeekerWebAddressRequest createJobSeekerWebAddressRequest){
        return jobSeekerWebAddressService.add(createJobSeekerWebAddressRequest);
    }
}
