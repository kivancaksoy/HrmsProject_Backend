package kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSchoolRequest {
    @NotBlank
    private int jobSeekerId;

    @NotBlank
    private String schoolName;

    @NotBlank
    private String department;

    @NotBlank
    private int startYear;

    private Integer graduatedYear;
}
