package kodlamaio.hrmsProject.api.controllers.jobSeekerCvInformationControllers;

import jakarta.validation.Valid;
import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.CoverLetterService;
import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateCoverLetterRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetCoverLetterResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coverLetters")
public class CoverLettersController {

    private final CoverLetterService coverLetterService;

    @Autowired
    public CoverLettersController(CoverLetterService coverLetterService) {
        this.coverLetterService = coverLetterService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateCoverLetterRequest createCoverLetterRequest){
        return coverLetterService.add(createCoverLetterRequest);
    }

    @GetMapping("/getCoverLetterByJobSeekerId")
    public DataResult<GetCoverLetterResponse> getCoverLetterByJobSeekerId(@RequestParam int jobSeekerId){
        return coverLetterService.getCoverLetterByJobSeekerId(jobSeekerId);
    }
}
