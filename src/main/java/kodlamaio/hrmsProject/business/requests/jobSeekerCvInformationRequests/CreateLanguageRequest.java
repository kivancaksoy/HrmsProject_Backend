package kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLanguageRequest {
    @NotNull
    private int jobSeekerId;

    @NotBlank
    private String languageName;

    @Min(value = 1)
    @Max(value = 5)
    private int languageLevel;

}
