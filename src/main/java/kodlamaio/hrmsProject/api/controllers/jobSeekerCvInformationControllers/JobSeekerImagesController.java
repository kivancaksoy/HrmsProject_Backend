package kodlamaio.hrmsProject.api.controllers.jobSeekerCvInformationControllers;

import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.JobSeekerImageService;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value = "/api/jobSeekerImages", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
public class JobSeekerImagesController {
    private final JobSeekerImageService jobSeekerImageService;

    public JobSeekerImagesController(JobSeekerImageService jobSeekerImageService) {
        this.jobSeekerImageService = jobSeekerImageService;
    }


    @PostMapping("/uploadFile")
    public Result uploadFile(@RequestParam MultipartFile file, @RequestParam int jobSeekerId) {
        return jobSeekerImageService.uploadFile(file, jobSeekerId);
    }

}
