package kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobExperienceRequest {
    @NotBlank
    private int jobSeekerId;

    @NotBlank
    private String companyName;

    @NotBlank
    private String position;

    @NotBlank
    private Date startYear;

    private Date endYear;

}
