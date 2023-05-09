package kodlamaio.hrmsProject.api.controllers.jobSeekerCvInformationControllers;

import jakarta.validation.Valid;
import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.LanguageService;
import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateLanguageRequest;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated //List içindeki objelerin validationları için eklendi.
@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private final LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody List<CreateLanguageRequest> createLanguageRequests) {
        return languageService.add(createLanguageRequests);
    }
}
