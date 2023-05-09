package kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSchoolRequest {
    @Min(1)
    @NotNull
    private int jobSeekerId;

    @NotBlank
    private String schoolName;

    @NotBlank
    private String department;

    @Min(1950)
    @NotNull
    private int startYear;

    private Integer graduatedYear;
}
