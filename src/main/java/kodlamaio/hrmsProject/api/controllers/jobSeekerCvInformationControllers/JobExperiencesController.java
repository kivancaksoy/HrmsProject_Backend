package kodlamaio.hrmsProject.api.controllers.jobSeekerCvInformationControllers;

import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.JobExperienceService;
import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateJobExperienceRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllJobExperiencesResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperiencesController {
    private final JobExperienceService jobExperienceService;

    public JobExperiencesController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody List<CreateJobExperienceRequest> createJobExperienceRequests){
        return jobExperienceService.add(createJobExperienceRequests);
    }

    @GetMapping("/getAllByJobSeekerIdOrderByGraduatedYearDesc")
    public DataResult<List<GetAllJobExperiencesResponse>> getAllByJobSeekerIdOrderByGraduatedYearDesc(@RequestParam int jobSeekerId){
        return jobExperienceService.getAllByJobSeekerIdOrderByGraduatedYearDesc(jobSeekerId);
    }
}
