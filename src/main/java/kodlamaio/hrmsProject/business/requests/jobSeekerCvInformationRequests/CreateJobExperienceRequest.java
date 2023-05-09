package kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobExperienceRequest {
    @NotNull
    @Min(1)
    private int jobSeekerId;

    @NotBlank
    private String companyName;

    @NotBlank
    private String position;

    @NotNull
    private Date startYear;

    private Date endYear;

}
