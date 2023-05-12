package kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnologiesResponse {
    private int id;
    private int jobSeekerId;
    private String technologyName;
}
