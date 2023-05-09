package kodlamaio.hrmsProject.api.controllers.jobSeekerCvInformationControllers;

import jakarta.validation.Valid;
import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.SchoolService;
import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateSchoolRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllSchoolsResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid List<CreateSchoolRequest> createSchoolRequests) {
        return schoolService.add(createSchoolRequests);
    }

    @GetMapping("/getAllByJobSeekerIdOrderByGraduatedYearDesc")
    public DataResult<List<GetAllSchoolsResponse>> getAllByJobSeekerIdOrderByGraduatedYearDesc(@RequestParam int jobSeekerId) {
        return schoolService.getAllByJobSeekerIdOrderByGraduatedYearDesc(jobSeekerId);
    }
}
