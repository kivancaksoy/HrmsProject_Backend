package kodlamaio.hrmsProject.api.controllers.jobSeekerCvInformationControllers;

import jakarta.validation.Valid;
import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.TechnologyService;
import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateTechnologyRequest;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/technologies")
public class TechnologiesController {
    private final TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateTechnologyRequest createTechnologyRequest){
        return technologyService.add(createTechnologyRequest);
    }
}
