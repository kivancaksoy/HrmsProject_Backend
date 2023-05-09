package kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCoverLetterRequest {
    @NotNull
    @Min(1)
    private int jobSeekerId;

    @NotBlank
    private String coverLetter;
}
