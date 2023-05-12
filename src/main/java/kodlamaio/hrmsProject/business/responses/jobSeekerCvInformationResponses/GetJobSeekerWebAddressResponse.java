package kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetJobSeekerWebAddressResponse {
    private int jobSeekerId;
    private String githubAddress;
    private String linkedinAddress;
}
