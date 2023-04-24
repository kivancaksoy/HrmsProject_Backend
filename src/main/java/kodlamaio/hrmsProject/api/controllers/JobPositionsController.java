package kodlamaio.hrmsProject.api.controllers;

import kodlamaio.hrmsProject.business.abstracts.JobPositionService;
import kodlamaio.hrmsProject.business.responses.GetAllJobPositionsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
@AllArgsConstructor
public class JobPositionsController {
    private JobPositionService jobPositionService;

    @GetMapping("/getall")
    public List<GetAllJobPositionsResponse> getAll(){
        List<GetAllJobPositionsResponse> result = jobPositionService.getAll();
        return result;
    }
}
