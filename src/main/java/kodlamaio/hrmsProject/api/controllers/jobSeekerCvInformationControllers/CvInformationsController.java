package kodlamaio.hrmsProject.api.controllers.jobSeekerCvInformationControllers;

import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.CvInformationService;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllCvInformationResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cvInformations")
public class CvInformationsController {
    private final CvInformationService cvInformationService;

    public CvInformationsController(CvInformationService cvInformationService) {
        this.cvInformationService = cvInformationService;
    }

    @GetMapping("/getAllCvInformationByJobSeekerId")
    public DataResult<GetAllCvInformationResponse> getAllCvInformationByJobSeekerId(@RequestParam int jobSeekerId){
        return cvInformationService.getAllCvInformationByJobSeekerId(jobSeekerId);
    }
}
