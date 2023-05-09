package kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobSeekerWebAddressRequest {
    @NotNull
    @Min(1)
    private int jobSeekerId;

    private String githubAddress;

    private String linkedinAddress;
}
