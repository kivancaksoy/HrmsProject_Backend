package kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguagesResponse {
    private int id;
    private int jobSeekerId;
    private String languageName;
}
